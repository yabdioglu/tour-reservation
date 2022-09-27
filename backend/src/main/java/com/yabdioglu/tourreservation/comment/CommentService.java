package com.yabdioglu.tourreservation.comment;

import com.yabdioglu.tourreservation.comment.vm.CommentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    void addComment(CommentRequest commentRequest);

    Page<Comment> findByTourId(Long tourId, Pageable pageable);
}
