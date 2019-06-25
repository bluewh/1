package com.ddc.server.service;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.server.entity.DdcPicture;

import java.util.List;

public interface IDDCPictureService extends IService<DdcPicture> {
   List<DdcPicture>selectPictureList();
}
