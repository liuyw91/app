package com.yunmi.app.service.crm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunmi.app.constant.Constant;
import com.yunmi.app.mapper.crm.TbUserMapper;
import com.yunmi.app.model.crm.TbUser;
import com.yunmi.app.model.crm.TbUserHeadImgApproval;
import com.yunmi.app.model.crm.TbUserPhotoWall;
import com.yunmi.app.utils.MapUtil;
import com.yunmi.app.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class TbUserService extends ServiceImpl<TbUserMapper, TbUser> {

    @Autowired
    TbUserPhotoWallService tbUserPhotoWallService;

    @Autowired
    TbUserHeadImgApprovalService tbUserHeadImgApprovalService;

    /**
     * 用户统计
     * @return
     */
    public Map<String, Long> countUser(Map<String, Object> params) {
        return this.baseMapper.countUser(params);
    }

    /**
     * 保存用户信息及照片信息
     * @param tbUser
     * @return
     * @throws Exception
     */
    public void saveUser(TbUser tbUser) throws Exception {
        tbUser.setUserFlag("0");
        tbUser.setStatus("1");
        tbUser.setCreateDate(new Date(System.currentTimeMillis()));
        saveOrUpdate(tbUser);
        String photoWalls = tbUser.getPhotoWalls();
        List<TbUserPhotoWall> tbUserPhotoWallList = new ArrayList<>();
        // 保存照片墙
        if (!StringUtils.isBlank(photoWalls.trim())) {
            for (String imgUrl : photoWalls.split(" ")) {
                TbUserPhotoWall tbUserPhotoWall = new TbUserPhotoWall();
                tbUserPhotoWall.setImgUrl(imgUrl);
                tbUserPhotoWall.setUserId(tbUser.getId());
                tbUserPhotoWall.setStatus("0");
                tbUserPhotoWall.setCreateDate(new Date(System.currentTimeMillis()));
                tbUserPhotoWallList.add(tbUserPhotoWall);
            }
            tbUserPhotoWallService.saveBatch(tbUserPhotoWallList);
        }
        // 保存未审核状态
        TbUserHeadImgApproval approval = new TbUserHeadImgApproval();
        approval.setId(tbUser.getId());
        approval.setCheckStatus(0);
        approval.setCheckDate(new Date(System.currentTimeMillis()));
        tbUserHeadImgApprovalService.saveOrUpdate(approval);
    }

    /**
     * 自定义用户列表 sql 语句分页查询
     * @param page
     * @param queryWrapper
     * @return
     */
    public List<TbUser> queryListByPage(IPage page, QueryWrapper<TbUser> queryWrapper){
        return this.baseMapper.queryListByPage(page, queryWrapper);
    }

    /**
     * 自定义审核列表 sql 语句分页查询
     * @param page
     * @param queryWrapper
     * @return
     */
    public List<TbUser> queryApprovalListByPage(IPage page, QueryWrapper<TbUser> queryWrapper){
        return this.baseMapper.queryApprovalListByPage(page, queryWrapper);
    }

    /**
     * 头像审核操作
     * @param params
     */
    public void approval(Map<String, Object> params) throws RuntimeException {
        // 审核操作：-3，-2，-1，1
        int operate = MapUtil.getValueInt(params,"operate");
        String userId = MapUtil.getValueStr(params,"userid");
        QueryWrapper<TbUserHeadImgApproval> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("CREATE_USER", userId).eq("CHECK_STATUS", Constant.NUM_0);
        TbUserHeadImgApproval baseApproval = tbUserHeadImgApprovalService.getOne(queryWrapper);
        baseApproval.setCheckDate(new Date(System.currentTimeMillis()));
        baseApproval.setCheckUser(UserUtils.getCurrentUser().getUsername());
        if(!StringUtils.isBlank(userId) && operate != 0){
            if(operate == 1){ // 通过审核
                // 更新head_img
                if(null != baseApproval){
                    if(!StringUtils.isBlank(baseApproval.getHeadImg())){//
                        TbUser baseUser = getById(userId);
                        baseUser.setHeadImg(baseApproval.getHeadImg());
                        updateById(baseUser);
                    }
                }else {
                    throw new RuntimeException("此用户无待审核头像！");
                }
            }
            // 更新审核表数据
            baseApproval.setCheckStatus(operate);
            tbUserHeadImgApprovalService.saveOrUpdate(baseApproval);
        }else{
            throw new RuntimeException("参数缺失");
        }
    }

    /**
     * 获取指定条件下第几个用户
     * @param wrapper
     * @return
     */
    public TbUser getSomeUser(Map<String, Object> wrapper) {
        return this.baseMapper.querySomeUser(wrapper);
    }
}
