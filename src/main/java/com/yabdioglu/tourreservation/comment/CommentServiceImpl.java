package com.yabdioglu.tourreservation.comment;

import com.yabdioglu.tourreservation.comment.vm.CommentRequest;
import com.yabdioglu.tourreservation.tour.TourService;
import com.yabdioglu.tourreservation.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;
    private UserService userService;
    private TourService tourService;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, TourService tourService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.tourService = tourService;
    }

    @Override
    public void addComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        convertToComment(commentRequest, comment);
        commentRepository.save(comment);
    }

    private void convertToComment(CommentRequest commentRequest, Comment comment) {
        comment.setUser(userService.findById(commentRequest.getUserId()));
        comment.setTour(tourService.getById(commentRequest.getTourId()));
        comment.setRating(commentRequest.getRating());
        comment.setComment(commentRequest.getComment());
    }

    @Override
    public Page<Comment> findByTourId(Long tourId, Pageable pageable) {
        return commentRepository.findByTourId(tourId, pageable);
    }
}
