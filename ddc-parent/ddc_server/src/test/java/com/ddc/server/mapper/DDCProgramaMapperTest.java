package com.ddc.server.mapper;

import com.ddc.server.entity.DdcPrograma;
import org.junit.Test;

import javax.annotation.Resource;

public class DDCProgramaMapperTest extends BaseTest{
@Resource private DDCProgramaMapper programaMapper;
@Test
public void testInsert(){

    for (int i=0;i<25;i++){
        DdcPrograma programa=new DdcPrograma("栏目"+i,"图片",0L,0L);
        programaMapper.insert(programa);

    }
}
}