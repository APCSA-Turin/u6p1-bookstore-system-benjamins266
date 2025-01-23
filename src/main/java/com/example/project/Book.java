package com.example.project;

public class Book{

    /*declares instance variables that give information about the book
      title, author, the year it was published, the isbn, and the quantity of books*/
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    //constructor that initialize the instance variables of the Book class
    public Book(String title, String author, int yearPublished, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    //returns the title of the book
    public String getTitle() {
        return title;
    }

    //sets or changes the title of the book
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    //returns the author of the book
    public String getAuthor() {
        return author;
    }

    //sets or changes the author of the book
    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    //returns the year the book was published
    public int getYearPublished() {
        return yearPublished;
    }

    //changes the year the book was published
    public void setYearPublished(int newYearPublished) {
        yearPublished = newYearPublished;
    }

    //returns the isbn
    public String getIsbn() {
        return isbn;
    }

    //sets or changes the isbn
    public void setIsbn(String newIsbn) {
        isbn = newIsbn;
    }

    //returns the quantity of the book
    public int getQuantity() {
        return quantity;
    }

    //sets or changes the quantity of the book
    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    /*returns all of the information of the book
      returns the attributes of the book, title, author, year published, isbn, and quanity*/
    public String bookInfo() 
    {
        return "Title: " + title + ", " + "Author: " + author + ", Year: " + yearPublished + ", " + "ISBN: " + isbn + ", " + "Quantity: " + quantity; 
    }
       
}