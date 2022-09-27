package com.yabdioglu.tourreservation.comment.vm;

import com.yabdioglu.tourreservation.comment.Comment;
import lombok.Data;

@Data
public class CommentResponse {

    private Long id;

    private Long userId;

    private Long tourId;

    private String comment;

    private double rating;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getUser().getId();
        this.tourId = comment.getTour().getId();
        this.comment = comment.getComment();
        this.rating = comment.getRating();
    }
}
