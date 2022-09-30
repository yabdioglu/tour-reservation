package com.yabdioglu.tourreservation.tour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yabdioglu.tourreservation.comment.Comment;
import com.yabdioglu.tourreservation.favorite.Favorite;
import com.yabdioglu.tourreservation.reservation.Reservation;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tours")
@Getter
@Setter
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

    @OneToMany(mappedBy = "tour", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    @JsonIgnore
    @JsonManagedReference
    private List<Comment> comments;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    public double getRatingAverage() {
        if(comments == null || comments.isEmpty()) {
            return 0;
        }
        double total = 0;
        for(Comment comment : comments) {
            total += comment.getRating();
        }
        double average = Double.parseDouble(df.format(total / comments.size()));
        return average;
    }

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPriceForAdult() {
        return priceForAdult;
    }

    public void setPriceForAdult(BigDecimal priceForAdult) {
        this.priceForAdult = priceForAdult;
    }

    public BigDecimal getPriceForChild() {
        return priceForChild;
    }

    public void setPriceForChild(BigDecimal priceForChild) {
        this.priceForChild = priceForChild;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public boolean isBestTour() {
        return bestTour;
    }

    public void setBestTour(boolean bestTour) {
        this.bestTour = bestTour;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isQuotaActive() {
        return quotaActive;
    }

    public void setQuotaActive(boolean quotaActive) {
        this.quotaActive = quotaActive;
    }

    public void setRatingAverage(double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }*/

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priceForAdult=" + priceForAdult +
                ", priceForChild=" + priceForChild +
                ", quota=" + quota +
                ", bestTour=" + bestTour +
                ", active=" + active +
                ", quotaActive=" + quotaActive +
                ", ratingAverage=" + ratingAverage +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
