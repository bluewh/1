package com.ddc.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ddc.server.entity.DDCAdmin;
import com.ddc.server.entity.DdcMessage;
import com.ddc.server.mapper.DDCAdminMapper;
import com.ddc.server.mapper.DDCMessageMapper;
import com.ddc.server.service.IDDCAdminService;
import com.ddc.server.service.IDDCMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class DDCMessageServiceImpl extends ServiceImpl<DDCMessageMapper, DdcMessage> implements IDDCMessageService {
@Resource
private DDCMessageMapper messageMapper;


}
