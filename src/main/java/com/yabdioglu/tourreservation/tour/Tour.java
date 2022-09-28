package com.yabdioglu.tourreservation.tour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yabdioglu.tourreservation.comment.Comment;
import com.yabdioglu.tourreservation.favorite.Favorite;
import com.yabdioglu.tourreservation.reservation.Reservation;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tours")
@Data
public class Tour {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "price_for_adult")
    private BigDecimal priceForAdult;

    @Column(name = "price_for_child")
    private BigDecimal priceForChild;

    @Column(name = "quota")
    private int quota;

    @Column(name="best_tour", columnDefinition = "boolean default false")
    private boolean bestTour;

    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;

    @Transient
    private boolean quotaActive;

    @Transient
    private double ratingAverage;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Comment> comments;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    public double getRatingAverage() {
        if(comments == null) {
            return 0;
        }
        double total = 0;
        for(Comment comment : comments) {
            total += comment.getRating();
        }
        double average = total / comments.size();
        return average;
    }
}
