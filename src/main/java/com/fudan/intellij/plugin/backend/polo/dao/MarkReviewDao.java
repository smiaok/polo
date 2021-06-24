package com.fudan.intellij.plugin.backend.polo.dao;

import com.fudan.intellij.plugin.backend.polo.entity.MarkReview;
import com.fudan.intellij.plugin.backend.polo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MarkReviewDao {

    @Insert("INSERT INTO mark_review(mark_review_id, marker, project, version, file, line, type, status,comment,branch)" +
            "values(#{markReviewId}, #{marker},#{project},#{version},#{file},#{line},#{type},#{status},#{comment},#{branch})")
    @Options(useGeneratedKeys = true, keyProperty = "markReviewId", keyColumn = "mark_review_id")
    int insertMarkReview(MarkReview markReview);

    @Update("update mark_review set status = #{status} where mark_review_id = #{markReviewId}")
    int updateMarkReviewStatus(long markReviewId, String status);

    @Select("SELECT * FROM mark_review WHERE marker = #{username}")
    List<MarkReview> findMarkReviewByMarker(String username);

    @Select("select * from mark_review where mark_review_id in (select mark_review_id from review_task where reviewer = #{username})")
    List<MarkReview> findMarkReviewByReviewer(String username);

    @Select("select * from user where username in (select reviewer from review_task where mark_review_id = #{markReviewId})")
    List<User> findReviewerByMarkReview(long markReviewId);

    @Insert("insert into review_task(mark_review_id,reviewer) values(#{markReviewId},#{reviewer})")
    @Options(useGeneratedKeys = true, keyProperty = "reviewTaskId", keyColumn = "review_task_id")
    int insertReviewTask(long markReviewId, String reviewer);

    @Select("select * from mark_review")
    List<MarkReview> getAllMarkReview();

    @Update("update mark_review set file = #{file} where mark_review_id = #{markReviewId}")
    int updateFilePath(long markReviewId, String file);

    @Update("update mark_review set comment = #{comment} where mark_review_id = #{markReviewId}")
    int updateComment(long markReviewId, String comment);
}
