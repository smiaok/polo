package com.fudan.intellij.plugin.backend.polo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MarkReview {

    private long markReviewId;

    private String marker;

    private String project;

    private String version;

    private String file;

    private String line;

    private String type;

    private String status;

    private String comment;

    private String branch;

    private Date createTime;

    private Date updateTime;
}
