package com.lucifer.lab.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="tbl_ratings")
public class Rating {
    @Id
    private String ratingId;

    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
