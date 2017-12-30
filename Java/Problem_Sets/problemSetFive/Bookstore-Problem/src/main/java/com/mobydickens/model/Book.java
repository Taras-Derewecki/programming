package com.mobydickens.model;



/**
 * Created by Taras on 11/20/2016.
 */

public class Book
{
    private int bookID, month, day, year;
    private String title,author;
    private long isbn;
//    private DateTime(int month, int day, int year) datePublished;
    Genre genre;
    private double price;

    public Book(int bookID, int month, int day, int year, String title, String author, long isbn, Genre genre, double price)
    {
        this.bookID = bookID;
        this.month = month;
        this.day = day;
        this.year = year;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.price= price;
    }

    public int getBookID() {return bookID;}

    public void setBookID(int bookID) {this.bookID = bookID;}

    public int getMonth() {return month;}

    public void setMonth(int month) {this.month = month;}

    public int getDay() {return day;}

    public void setDay(int day) {this.day = day;}

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}

    public void setAuthor(String author) {this.author = author;}

    public long getIsbn() {return isbn;}

    public void setIsbn(long isbn) {this.isbn = isbn;}

    public Genre getGenre() {return genre;}

    public void setGenre(Genre genre) {this.genre = genre;}

    public double getPrice(){return price;}

    public void setPrice(double price){this.price = price;}
}

