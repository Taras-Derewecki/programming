package com.mobydickens.model;

/**
 * Created by Taras on 11/21/2016.
 */
public enum Genre
{
    HORROR("horror"), NONFICTION("non-fiction"), ROMANCE("romance"),
    CLASSICS("classics");

    private String genre;

    Genre(String genre) {this.genre = genre;}

    public String getGenre() {return genre;}
}
