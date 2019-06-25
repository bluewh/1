package com.ddc.server.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.server.entity.DdcPicture;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DDCPictureMapper extends BaseMapper<DdcPicture> {
    @Select("select * from ddc_picture")
    List<DdcPicture> selectAll();

}
