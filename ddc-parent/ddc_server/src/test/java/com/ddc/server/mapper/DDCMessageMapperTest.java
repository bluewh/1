package com.ddc.server.mapper;

import com.ddc.server.entity.DdcMessage;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

public class DDCMessageMapperTest extends BaseTest {
@Resource
private DDCMessageMapper messageMapper;

@Test
public void testInsert(){

    for (int i = 0; i <20 ; i++) {
        DdcMessage message=new DdcMessage("user"+i,0,12345678900L,"hello@qq.com","无","北进市海淀区","无",0,0L,0L);
        messageMapper.insert(message);
        
    }
  }
}