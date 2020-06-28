package com.yunmi.app.service.crm;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunmi.app.mapper.crm.TbUserPhotoWallMapper;
import com.yunmi.app.model.crm.TbUserPhotoWall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TbUserPhotoWallService extends ServiceImpl<TbUserPhotoWallMapper, TbUserPhotoWall> {


}
