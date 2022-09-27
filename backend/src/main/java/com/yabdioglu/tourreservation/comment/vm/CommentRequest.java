package com.yabdioglu.tourreservation.comment.vm;

import lombok.Data;

@Data
public class CommentRequest {

    private Long userId;

    private Long tourId;

    private double rating;

    private String comment;
}
