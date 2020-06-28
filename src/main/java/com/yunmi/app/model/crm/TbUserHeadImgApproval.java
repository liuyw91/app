package com.yunmi.app.model.crm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUserHeadImgApproval {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID")
    private String id;

    /**
     * 头像
     */
    @TableField("HEAD_IMG")
    private String headImg;

    /**
     * 审核状态-3：永久封号-2：封号；-1：不通过；0：待审核；1：通过；
     */
    @TableField("CHECK_STATUS")
    private int checkStatus;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("CHECK_DATE")
    private Date checkDate;


    /**
     * 审核人
     */
    @TableField("CHECK_USER")
    private String checkUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("CREATE_DATE")
    private Date createDate;


    /**
     * 创建人
     */
    @TableField("CREATE_USER")
    private String createUser;

}
