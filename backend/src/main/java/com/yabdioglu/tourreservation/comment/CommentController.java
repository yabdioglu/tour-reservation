package com.yabdioglu.tourreservation.comment;

import com.yabdioglu.tourreservation.comment.vm.CommentRequest;
import com.yabdioglu.tourreservation.comment.vm.CommentResponse;
import com.yabdioglu.tourreservation.shared.GenericResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public GenericResponse addComment(@RequestBody CommentRequest commentRequest) {
        commentService.addComment(commentRequest);
        return new GenericResponse("added comment");
    }

    @GetMapping("/tours/{tourId}/comments")
    public Page<CommentResponse> findByTourId(@PathVariable Long tourId, Pageable pageable) {
        return commentService.findByTourId(tourId, pageable).map(CommentResponse::new);
    }
}
