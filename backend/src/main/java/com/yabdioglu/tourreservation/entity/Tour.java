package com.yabdioglu.tourreservation.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tour")
@Data
public class Tour {

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

    @Column(name = "active", columnDefinition = "boolean default false")
    private boolean active;

    @Transient
    private boolean quotaActive;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;
}
