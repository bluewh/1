package com.ddc.server.controller;
import java.lang.String;
import java.util.List;

import com.ddc.server.config.web.http.ResponseHelper;
import com.ddc.server.config.web.http.ResponseModel;
import com.ddc.server.entity.DdcPicture;

import com.ddc.server.mapper.DDCPictureMapper;
import com.ddc.server.service.impl.DDCPictureServiceImpl;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/picture")
@Controller
@Slf4j
public class PictureController {
        @Resource
        private DDCPictureMapper pictureMapper;
        @RequestMapping("/add")
       public String jumpAdd(Model model)throws Exception{
            return "picture-add";
        }


    @RequestMapping("/addAction")
    @ResponseBody
    public void insertAdd(@RequestParam(value = "p_name",required = true) String pName,
                          @RequestParam(value = "p_classify",required = true) String pClassify,
                          @RequestParam(value = "p_ordervalue",required =true ) Integer pOrdervalue,
                          @RequestParam(value = "p_author",required = true) String pAuthor,
                          @RequestParam(value = "p_tags",required = true) String pTags,Model model) throws Exception{
        DdcPicture picture = new DdcPicture(pName,pClassify,pOrdervalue,pAuthor,pTags);

        pictureMapper.insert(picture);
    }




    @Resource
 private DDCPictureServiceImpl ddcPictureService;

    @RequestMapping("/pictureList")
     @ResponseBody
     //@RequestMapping("/pictureList")
     public ResponseModel<List<DdcPicture>> getPictureList(HttpServletResponse response){
//        @Resource
//        private DDCPictureServiceImpl ddcPictureService;
        List<DdcPicture> pictureList=ddcPictureService.selectPictureList();

        return  ResponseHelper.buildResponseModel(pictureList);
    }
////    @RequestMapping("/list")
//    @ResponseBody
//    public ResponsePageModel<DdcPicture>list(@RequestParam(name="page",required = false,defaultValue="1")Integer pageNumber,@RequestParam(name = "limit",required = false,defaultValue = "10")Integer pageSize,String start,String end,String keywords)throws Exception{
//        Wrapper <DdcPicture>wrapper =new EntityWrapper<>();
//        if(!StringUtils.isEmpty(start)){
//            wrapper=wrapper.ge("create_time",start);
//        }
//        if(!StringUtils.isEmpty(end)){
//            wrapper=wrapper.le("create_time",end);
//        }
//        if(!StringUtils.isEmpty(keywords)){
//            wrapper=wrapper.like("username",keywords);
//        }
//        ResponsePageModel<DdcPicture> page = ResponsePageHelper.buildResponseModel(
//                pictureService.selectPage(new page<>(pageNumber,pageSize),wrapper));
//        return page;
//    }

//    @RequestMapping("/delete")
//    @ResponseBody
//    public ResponseModel<String> delete(@RequestParam String ids) throws Exception {
//        String[] arr = ids.split(",");
//        List<Long> idArray = new ArrayList<>(5);
//        for (int i = 0; i < arr.length; i++) {
//            if (!StringUtils.isEmpty(arr[i]) && org.apache.commons.lang3.StringUtils.isNumeric(arr[i])) {
//                idArray.add(Long.valueOf(arr[i]));
//            }
//        }
//        if (!CollectionUtils.isEmpty(idArray)) {
//            pictureService.deleteBatchIds(idArray);
//            return ResponsePageHelper.buildResponseModel("删除成功");
//        } else {
//            return new ResponseModel<String>(
//                    "删除失败", ResponseModel.FAIL.getCode()
//            );
//
//        }
//
//    }
}