package com.ddc.server.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 *  ddc_message
 * @author 大狼狗 2019-06-18
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("ddc_message")
public class DdcMessage extends Model<DdcMessage> {
    private static final long serialVersionUID = 1L;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * username
     */
    private String username;

    /**
     * sex
     */
    private Integer sex;

    /**
     * phone
     */
    private Long mobile;

    /**
     * email
     */
    private String email;


    private String path;

    /**
     * address
     */
    private String city;

    private String remark;

    /**
     * state
     */
    private Integer state;



    /**
     * introduce
     */


    /**
     * create_p
     */
    @TableField("create_by")
    private Long createP;

    /**
     * create_t
     */
    @TableField("create_time")
    private Long createT;

    /**
     * update_p
     */
    @TableField("update_by")
    private Long updateP;

    /**
     * update_t
     */
    @TableField("update_time")
    private Long updateT;

    /**
     * delete_f
     */
    @TableField("del_flag")
    private Integer delF;


    public DdcMessage(String username, Integer sex, Long mobile, String email, String path, String city, String remark, Integer state, Long createP, Long updateP) {
        this.username = username;
        this.sex = sex;
        this.mobile = mobile;
        this.email = email;
        this.path = path;
        this.city = city;
        this.remark = remark;
        this.state = state;

        this.createT = System.currentTimeMillis();
        this.createP = createP;
        this.updateP = updateP;
        this.updateT = System.currentTimeMillis();
        this.delF = 0;
    }

}