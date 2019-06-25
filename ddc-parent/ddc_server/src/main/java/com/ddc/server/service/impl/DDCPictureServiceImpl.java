package com.ddc.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ddc.server.entity.DDCAdmin;
import com.ddc.server.entity.DdcPicture;
import com.ddc.server.mapper.DDCAdminMapper;
import com.ddc.server.mapper.DDCPictureMapper;
import com.ddc.server.service.IDDCAdminService;
import com.ddc.server.service.IDDCPictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dingpengfei
 * @since 2019-05-09
 */
@Service
public class DDCPictureServiceImpl extends ServiceImpl<DDCPictureMapper, DdcPicture> implements IDDCPictureService {
  @Resource private DDCPictureMapper pictureMapper;
    @Override
    public List<DdcPicture>selectPictureList(){
        List<DdcPicture> pictureList=pictureMapper.selectAll();
        return pictureList;
    }

}
