package com.yabdioglu.tourreservation.favorite;

import com.yabdioglu.tourreservation.favorite.vm.FavoriteRequest;
import com.yabdioglu.tourreservation.tour.TourService;
import com.yabdioglu.tourreservation.user.User;
import com.yabdioglu.tourreservation.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService{

    private FavoriteRepository favoriteRepository;
    private UserService userService;
    private TourService tourService;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, UserService userService, TourService tourService) {
        this.favoriteRepository = favoriteRepository;
        this.userService = userService;
        this.tourService = tourService;
    }

    @Override
    public Page<Favorite> findByUserId(Long userId, Pageable pageable) {
        return favoriteRepository.findByUserId(userId, pageable);
    }

    @Override
    public void addFavorite(FavoriteRequest favoriteRequest) {
        Favorite favorite = new Favorite();
        favorite.setUser(userService.findById(favoriteRequest.getUserId()));
        favorite.setTour(tourService.getById(favoriteRequest.getTourId()));
        favoriteRepository.save(favorite);
    }
}
