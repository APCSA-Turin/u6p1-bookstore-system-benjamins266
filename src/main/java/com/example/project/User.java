package com.example.project;

public class User{
    //attributes for name, Id, and the bookList array, initialized to hold up to 5 values
    private String name;
    private String Id;
    private Book[] bookList = new Book[5]; 

    //constructor which initialized name and Id attributes
    public User(String name, String Id){
        this.name = name; 
        this.Id = Id;
    }
 
    //returns the name
    public String getName() {
        return name;
    }

    //sets or changes the name attribute to a newName
    public void setName(String newName) {
        name = newName;
    }

    //returns Id
    public String getId() {
        return Id;
    }

    //sets or changes the Id attribute to a newId
    public void setId(String newId) {
        Id = newId;
    }

    //returns bookList array
    public Book[] getBooks() {
        return bookList;
    }

    //sets or changes the bookList array to a newBook array
    public void setBooks(Book[] newBook) {
        bookList = newBook;
    }

    //returns a string that contains the information about the users books in the bookList array
    public String bookListInfo(){
        String str = "";
        //iterates through each book in bookList
        for(int i = 0; i<bookList.length; i++){
            //if the value of bookList[i] is null, it will set that slot to "empty"
            if(bookList[i]==null){
                str+="empty" + "\n";
            } else {
                //otherwise, it will add all of that books information to the string
                str += bookList[i].bookInfo() + "\n";
            }
        }
        return str;
    } 

    //returns all of the information about a user, name, Id, and their books
    public String userInfo(){
        return "Name: " + name + "\n" + "Id: " + Id + "\n" + "Books: " + "\n" + bookListInfo();
    } 

       
}