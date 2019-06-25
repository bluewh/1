package com.ddc.server.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.ddc.server.annotation.CurrentUser;
import com.ddc.server.config.web.http.ResponseHelper;
import com.ddc.server.config.web.http.ResponseModel;
import com.ddc.server.config.web.http.ResponsePageHelper;
import com.ddc.server.config.web.http.ResponsePageModel;
import com.ddc.server.entity.DDCAdmin;
import com.ddc.server.entity.DdcPrograma;
import com.ddc.server.mapper.DDCProgramaMapper;
import com.ddc.server.service.IDDCProgramaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录接口
 *
 * @author dingpengfei
 * @since 2019-05-09
 */

@RequestMapping("/programa")
@Controller

public class ProgramaController {
    @Resource
    private DDCProgramaMapper programaMapper;
    @Resource
    private IDDCProgramaService programaService;
//    @Resource
//    private IDDCAdminService adminService;
//
//
//    @RequestMapping("/index")
//    public String login(HttpServletRequest request, @RequestParam(value = "username",required = false) String username,
//                        @RequestParam(value = "password",required =false ) String password,
//                        HttpSession session, Model model) throws Exception {
//
//        return "/login";
//    }

    @RequestMapping("/insert")
    @ResponseBody
    public void insertAdd(@RequestParam(value = "programa_name", required = true) String name,
                          @RequestParam(value = "type_select", required = true) String type,
                          Model model) throws Exception {
        DdcPrograma programa = new DdcPrograma(name, type);
        programaMapper.insert(programa);
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponsePageModel<DdcPrograma> list(@RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNumber,
                                               @RequestParam(name = "limit", required = false, defaultValue = "10") Integer pageSize,
                                               String start, String end, String keywords) throws Exception {
        Wrapper<DdcPrograma> programa = new EntityWrapper<>();
        if (!StringUtils.isEmpty(keywords)) {
            programa = programa.like("name", keywords);
        }
        ResponsePageModel<DdcPrograma> page = ResponsePageHelper.buildResponseModel(
                programaService.selectPage(new Page<>(pageNumber, pageSize),
                        programa));
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
            programaService.deleteBatchIds(idArray);
            return ResponseHelper.buildResponseModel("删除成功");
        } else {
            return new ResponseModel<String>(
                    "删除失败", ResponseModel.FAIL.getCode()
            );
        }
    }
    @RequestMapping("/updateOrAdd")
    @ResponseBody
    public ResponseModel<String> updateOrAdd(@RequestBody DdcPrograma programa,
                                             @CurrentUser DDCAdmin admin) throws Exception {
        if(programa.getId()==null){
            programa.setCreateBy(admin.getId());
            programa.setCreateTime(System.currentTimeMillis());
            programa.setDelFlag(0);
        }
        programa.setUpdateBy(admin.getId());
        programa.setUpdateTime(System.currentTimeMillis());
        programaService.insertOrUpdate(programa);
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