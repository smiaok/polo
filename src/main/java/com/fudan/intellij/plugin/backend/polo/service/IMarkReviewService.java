package com.fudan.intellij.plugin.backend.polo.service;

import com.fudan.intellij.plugin.backend.polo.entity.MarkReview;
import com.fudan.intellij.plugin.backend.polo.entity.User;

import java.util.List;

public interface IMarkReviewService {

    boolean uploadMarkReview(MarkReview markReview);

    boolean updateMarkReviewStatus(long markReviewId,String status);

    List<MarkReview> getAllMarkReviewAsMarker(String username);

    List<MarkReview> getAllMarkReviewAsReviewer(String username);

    List<User> getAllReviewerForMarkReview(long markReviewId);

    boolean addReviewerForMarkReview(long markReviewId,String reviewer);

    List<MarkReview> getAllMarkReview();

    boolean updateFilePath(long markReviewId,String file);

    boolean updateComment(long markReviewId,String comment);
}
