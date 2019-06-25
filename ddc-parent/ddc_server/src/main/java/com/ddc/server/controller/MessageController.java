package com.ddc.server.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ddc.server.annotation.CurrentUser;
import com.ddc.server.config.web.http.ResponseHelper;
import com.ddc.server.config.web.http.ResponseModel;
import com.ddc.server.config.web.http.ResponsePageHelper;
import com.ddc.server.config.web.http.ResponsePageModel;
import com.ddc.server.entity.DDCAdmin;
import com.ddc.server.entity.DdcMessage;
import com.ddc.server.service.IDDCMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录接口
 *
 * @author dingpengfei
 * @since 2019-05-09
 */
@RequestMapping("/message")
@Controller
public class MessageController {
    @Resource
    private IDDCMessageService messageService;


    @RequestMapping("/list")
    @ResponseBody
    public ResponsePageModel<DdcMessage> list(@RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNumber,
                                                  @RequestParam(name = "limit", required = false, defaultValue = "10") Integer pageSize,
                                                  String start, String end, String keywords) throws Exception {
        Wrapper<DdcMessage> wrapper = new EntityWrapper<>();
        if (!StringUtils.isEmpty(start)) {
            wrapper = wrapper.ge("create_time", start);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper = wrapper.le("create_time", end);
        }
        if (!StringUtils.isEmpty(keywords)) {
            wrapper = wrapper.like("username", keywords);
        }
        ResponsePageModel<DdcMessage> page = ResponsePageHelper.buildResponseModel(
                messageService.selectPage(new Page<>(pageNumber, pageSize),
                        wrapper));
        return page;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public ResponseModel<String> delete(@RequestParam String ids) throws Exception {
        String[] arr = ids.split(",");
        List<Long> idArray = new ArrayList<>(5);
        for (int i = 0; i < arr.length; i++) {
            if (!StringUtils.isEmpty(arr[i]) && org.apache.commons.lang3.StringUtils.isNumeric(arr[i])) {
                idArray.add(Long.valueOf(arr[i]));
            }
        }
        if (!CollectionUtils.isEmpty(idArray)) {
           messageService.deleteBatchIds(idArray);
            return ResponseHelper.buildResponseModel("删除成功");
        } else {
            return new ResponseModel<String>(
                    "删除失败", ResponseModel.FAIL.getCode()
            );

        }

    }

    @RequestMapping("/updateOrAdd")
    @ResponseBody
    public ResponseModel<String> updateOrAdd(@RequestBody  DdcMessage message,
                                             @CurrentUser DDCAdmin admin) throws Exception {
        if(message.getId()==null){
            message.setCreateP(admin.getId());
            message.setCreateT(System.currentTimeMillis());
            message.setState(0);
            message.setDelF(0);
        }
        message.setUpdateP(admin.getId());
        message.setUpdateT(System.currentTimeMillis());
        messageService.insertOrUpdate(message);
//        if (!CollectionUtils.isEmpty(idArray)) {
//            suggestingsService.deleteBatchIds(idArray);
//            return ResponseHelper.buildResponseModel("删除成功");
//        } else {
//            return new ResponseModel<String>(
//                    "删除失败", ResponseModel.FAIL.getCode()
//            );
//
//        }
        return ResponseHelper.buildResponseModel("操作成功");
    }
}
