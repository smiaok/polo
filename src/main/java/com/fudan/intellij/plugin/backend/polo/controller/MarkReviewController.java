package com.fudan.intellij.plugin.backend.polo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.fudan.intellij.plugin.backend.polo.common.CommonResult;
import com.fudan.intellij.plugin.backend.polo.entity.MarkReview;
import com.fudan.intellij.plugin.backend.polo.entity.User;
import com.fudan.intellij.plugin.backend.polo.service.IMarkReviewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class MarkReviewController {

    @Resource
    private IMarkReviewService markReviewService;

    @SaCheckLogin
    @RequestMapping(value ="/uploadMarkReview",method = RequestMethod.POST)
    public CommonResult<Long> uploadMarkReview(@ModelAttribute MarkReview markReview){
        markReview.setMarker(StpUtil.getLoginIdAsString());
        if(markReviewService.uploadMarkReview(markReview)){
            return CommonResult.success(markReview.getMarkReviewId());
        }
        return CommonResult.failed();
    }

    @SaCheckLogin
    @RequestMapping(value ="/updateMarkReviewStatus",method = RequestMethod.POST)
    public CommonResult<Object> updateMarkReviewStatus(long markReviewId, String status){
        if(markReviewService.updateMarkReviewStatus(markReviewId, status)){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @SaCheckLogin
    @RequestMapping(value ="/getAllMarkReviewAsMarker",method = RequestMethod.POST)
    public CommonResult<List<MarkReview>> getAllMarkReviewAsMarker(){
        String username = StpUtil.getLoginIdAsString();
        return CommonResult.success(markReviewService.getAllMarkReviewAsMarker(username));
    }

    @SaCheckLogin
    @RequestMapping(value ="/getAllMarkReviewAsReviewer",method = RequestMethod.POST)
    public CommonResult<List<MarkReview>> getAllMarkReviewAsReviewer(){
        String username = StpUtil.getLoginIdAsString();
        return CommonResult.success(markReviewService.getAllMarkReviewAsReviewer(username));
    }

    @SaCheckLogin
    @RequestMapping(value ="/getAllReviewerForMarkReview",method = RequestMethod.POST)
    public CommonResult<List<User>> getAllReviewerForMarkReview(long markReviewId){
        return CommonResult.success(markReviewService.getAllReviewerForMarkReview(markReviewId));
    }

    @SaCheckLogin
    @RequestMapping(value ="/addReviewerForMarkReview",method = RequestMethod.POST)
    public CommonResult<Object> addReviewerForMarkReview(long markReviewId,String reviewer){
        if(markReviewService.addReviewerForMarkReview(markReviewId,reviewer)){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @SaCheckLogin
    @RequestMapping(value ="/getAllMarkReview",method = RequestMethod.POST)
    public CommonResult<List<MarkReview>> getAllMarkReview(){
            return CommonResult.success(markReviewService.getAllMarkReview());
    }

    @SaCheckLogin
    @RequestMapping(value ="/updateFilePath",method = RequestMethod.POST)
    public CommonResult<Boolean> updateFilePath(long markReviewId,String file){
        return CommonResult.success(markReviewService.updateFilePath(markReviewId,file));
    }

    @SaCheckLogin
    @RequestMapping(value ="/updateComment",method = RequestMethod.POST)
    public CommonResult<Boolean> updateComment(long markReviewId,String comment){
        return CommonResult.success(markReviewService.updateComment(markReviewId,comment));
    }

}
