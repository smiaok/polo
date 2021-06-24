package com.fudan.intellij.plugin.backend.polo.service.impl;


import com.fudan.intellij.plugin.backend.polo.dao.MarkReviewDao;
import com.fudan.intellij.plugin.backend.polo.dao.UserDao;
import com.fudan.intellij.plugin.backend.polo.entity.MarkReview;
import com.fudan.intellij.plugin.backend.polo.entity.User;
import com.fudan.intellij.plugin.backend.polo.service.IMarkReviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MarkReviewServiceImpl implements IMarkReviewService{

    @Resource
    private MarkReviewDao markReviewDao;

    @Override
    public boolean uploadMarkReview(MarkReview markReview){
        return markReviewDao.insertMarkReview(markReview) == 1;
    }

    @Override
    public boolean updateMarkReviewStatus(long markReviewId,String status){
        return markReviewDao.updateMarkReviewStatus(markReviewId,status) == 1;
    }

    @Override
    public List<MarkReview> getAllMarkReviewAsMarker(String username){
        return markReviewDao.findMarkReviewByMarker(username);
    };

    @Override
    public List<MarkReview> getAllMarkReviewAsReviewer(String username){
        return markReviewDao.findMarkReviewByReviewer(username);
    };

    @Override
    public List<User> getAllReviewerForMarkReview(long markReviewId){
        return markReviewDao.findReviewerByMarkReview(markReviewId);
    }

    @Override
    public boolean addReviewerForMarkReview(long markReviewId,String reviewer){
        return markReviewDao.insertReviewTask(markReviewId,reviewer) == 1;
    }

    @Override
    public List<MarkReview> getAllMarkReview(){
        return markReviewDao.getAllMarkReview();
    }

    @Override
    public boolean updateFilePath(long markReviewId,String file){
        return markReviewDao.updateFilePath(markReviewId, file) == 1;
    }

    @Override
    public boolean updateComment(long markReviewId,String comment){
        return markReviewDao.updateComment(markReviewId, comment) == 1;
    }

}
