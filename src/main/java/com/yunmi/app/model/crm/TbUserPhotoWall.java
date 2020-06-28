package com.yunmi.app.model.crm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Shawn Sun
 * @since 2019-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUserPhotoWall extends Model<TbUserPhotoWall> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 用户ID
     */
    @TableField("USER_ID")
    private String userId;

    /**
     * 图片地址
     */
    @TableField("IMG_URL")
    private String imgUrl;

    /**
     * 状态，-1删除，0正常
     */
    @TableField("STATUS")
    private String status;

    /**
     * 创建时间
     */
    @TableField("CREATE_DATE")
    private Date createDate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
