package com.mobydickens.model;

import javax.persistence.Entity;

/**
 * Created by Taras on 11/21/2016.
 */

@Entity
public enum Genre
{
    HORROR("horror"), NONFICTION("non-fiction"), ROMANCE("romance"),
    CLASSICS("classics");

    private String genre;

    Genre(String genre) {this.genre = genre;}

    public String getGenre() {return genre;}
}
