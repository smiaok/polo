package com.fudan.intellij.plugin.backend.polo.entity;

import lombok.Data;

@Data
public class ReviewTask {

    private long reviewTaskId;

    private long markReviewId;

    private String reviewer;
}
