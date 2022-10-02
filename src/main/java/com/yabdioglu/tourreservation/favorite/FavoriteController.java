package com.yabdioglu.tourreservation.favorite;

import com.yabdioglu.tourreservation.favorite.vm.FavoriteRequest;
import com.yabdioglu.tourreservation.favorite.vm.FavoriteResponse;
import com.yabdioglu.tourreservation.shared.GenericResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0")
public class FavoriteController {

    private FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/favorites/addFavorite")
    public GenericResponse addFavorite(@RequestBody FavoriteRequest favoriteRequest) {
        favoriteService.addFavorite(favoriteRequest);
        return new GenericResponse("added favorites");
    }

    @GetMapping("/users/{userId}/favorites")
    public Page<FavoriteResponse> findByUserId(@PathVariable Long userId, Pageable pageable) {
        return favoriteService.findByUserId(userId, pageable).map(FavoriteResponse::new);
    }

    @DeleteMapping("/favorites/{id}")
    public GenericResponse deleteFavorite(@PathVariable Long id) {
        favoriteService.delete(id);
        return new GenericResponse("Favorite removed");
    }
}
