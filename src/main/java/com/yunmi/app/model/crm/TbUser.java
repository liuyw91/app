package com.yunmi.app.model.crm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>用户</p>
 *
 * @author Shawn Sun
 * @since 2019-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUser extends Model<TbUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 手机
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 性别（1：男；0：女）
     */
    @TableField("GENDER")
    private String gender;

    /**
     * 微信号
     */
    @TableField("WECHAT_CODE")
    private String wechatCode;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("BIRTH_DAY")
    private Date birthDay;

    /**
     * 经度
     */
    @TableField("LONGITUDE")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @TableField("LATITUDE")
    private BigDecimal latitude;

    /**
     * 头像
     */
    @TableField("HEAD_IMG")
    private String headImg;

    /**
     * 星座
     */
    @TableField("CONSTELLATION")
    private String constellation;

    /**
     * 行业
     */
    @TableField("INDUSTRY")
    private String industry;

    /**
     * 工作领域
     */
    @TableField("WORK_AREA")
    private String workArea;

    /**
     * 个性签名
     */
    @TableField("SIGN")
    private String sign;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("CREATE_DATE")
    private Date createDate;

    /**
     * 状态,-1已注销，0未审核，1已审核，2已冻结
     */
    @TableField("STATUS")
    private String status;

    /**
     * 网易云信token
     */
    @TableField("WYYX_TOKEN")
    private String wyyxToken;

    /**
     * 设置-性别（1：男；0：女）
     */
    @TableField("SETTING_GENDER")
    private String settingGender;

    /**
     * 设置-年龄下限
     */
    @TableField("SETTING_AGE_MIN")
    private BigDecimal settingAgeMin;

    /**
     * 设置-年龄上限
     */
    @TableField("SETTING_AGE_MAX")
    private BigDecimal settingAgeMax;

    /**
     * 设置-距离（米）
     */
    @TableField("SETTING_DISTANCE")
    private BigDecimal settingDistance;
    
    /**
     * 身份标识，0假用户，1真用户
     */
    @TableField("USER_FLAG")
    private String userFlag;

    /**
     * 个人相册
     */
    @TableField(exist = false)
    private String photoWalls;

    /**
     * 审核状态
     */
    @TableField(exist = false)
    private String checkStatus;

    /**
     * 年龄
     */
    @TableField(exist = false)
    private String age;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
