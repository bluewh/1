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

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("ddc_picture")
public class DdcPicture extends Model<DdcPicture> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 图片标题 图片名称
     */
    @TableField("p_name")
    private String pName;

    /**
     * 分类栏目
     */
    @TableField("p_classify")
    private String pClassify;

    /**
     * 排序值
     */
    @TableField("p_ordervalue")
    private Integer pOrdervalue=0;

    /**
     * 图片作者
     */
    @TableField("p_author")
    private String pAuthor;

    /**
     * 标签 图片摘要
     */
    @TableField("p_tags")
    private String pTags="";

    /**
     * 更新时间
     */
    @TableField("p_updatetime")
    private Long pUpdatetime;

    /**
     * 发布状态
     */
    @TableField("p_publishstate")
    private Integer pPublishstate=0;

    /**
     * 图片
     */
    @TableField("picture")

    private String picture;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long createTime;
    /**
     * 创建人
     */
    @TableField("create_by")
    private Long createBy;
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

    public DdcPicture(String pName, String pClassify, Integer pOrdervalue, String pAuthor, String pTags, Long pUpdatetime, Integer pPublishstate, String picture, Long createBy,  Long updateBy ) {
        this.pName = pName;
        this.pClassify = pClassify;
        this.pOrdervalue = pOrdervalue;
        this.pAuthor = pAuthor;
        this.pTags = pTags;
        this.pUpdatetime = pUpdatetime;
        this.pPublishstate = pPublishstate;
        this.picture = picture;
        this.createBy = createBy;
        this.createTime = System.currentTimeMillis();
        this.updateBy = updateBy;
        this.updateTime = System.currentTimeMillis();
        this.delFlag=0;
    }
    public DdcPicture(String pName,String pClassify,Integer pOrdervalue,String pAuthor,String pTags){
        this.pName=pName;
        this.pClassify=pClassify;
        this.pOrdervalue=pOrdervalue;
        this.pAuthor=pAuthor;
        this.pTags=pTags;
    }
}