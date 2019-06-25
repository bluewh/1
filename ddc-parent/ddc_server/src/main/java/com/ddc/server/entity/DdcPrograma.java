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
 *  ddc_programa
 * @author yj 2019-06-20
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("ddc_programa")
public class DdcPrograma implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value="id",type= IdType.AUTO)
    private Long id;

    /**
     * 栏目名称
     */
    private String name;

    /**
     * 内容类型
     */
    private String type;

    /**
     * 创建人
     */
    @TableField("create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long createTime;

    /**
     * 更新人
     */
    @TableField("update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Long updateTime;

    /**
     * 删除标志
     */
    @TableField("delete_flag")
    private Integer delFlag;

    public DdcPrograma(String name, String type, Long createBy, Long updateBy) {
        this.name = name;
        this.type=type;
        this.createBy = createBy;
        this.createTime = System.currentTimeMillis();
        this.updateBy = updateBy;
        this.updateTime = System.currentTimeMillis();
    }
    public DdcPrograma(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
