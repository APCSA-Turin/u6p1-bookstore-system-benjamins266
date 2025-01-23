package com.example.project;

public class BookStore{

   //books is a dynamic array, that will hold Book objects
    private Book[] books = new Book[0];
    //users is a static array that at most, holds 10 User objects
    private User[] users = new User[10];

    //empty constructor
    public BookStore() { }

    //returns the users array
    public User[] getUsers(){
        return users;
    }

    //sets the users array to the new array
    public void setUsers(User[] newUser){
        users = newUser;
    }

    //returns the books array
    public Book[] getBooks(){
        return books;
    }

    //Adds a user to the "users" array
    public void addUser(User user){
        //iterates over the users array to find the first "null" spot, and adds the user in that spot
        for(int i = 0; i<users.length; i++){
            if(users[i] == null){
                users[i] = user;
                break;
            }
        }
    } 

    //Removes a user from the "users" array
    public void removeUser(User user){
        //iterates through the users array and finds the user in the array that is equal to the parameter
        for(int i = 0; i<users.length; i++){
            //Then it consolidates the the array by shifting users to the front of the array
            if(users[i] == user && users[i]!=null ){
                users[i] = null;
                consolidateUsers();
                break;
            }
        }
    }

    //arranges the users in the "users" array by moving the "null" spaces to the end of the array
    public void consolidateUsers(){
        int counting = 0;
        //iterates through each value of "users" array
        for(int i = 0; i<users.length; i++){
            //checks to see if the value is null
            if(users[i]!=null){
                //exchanges the value that is equal to null to the end of the array
                if(i!=counting){
                    users[counting] = users[i];
                    users[i] = null;
                }
                counting++;
            }
        }
    }

    //adds a book to the "book" array
    public void addBook(Book book){
        //creates a new temporary array
        Book[] temp = new Book[books.length+1];
        //iterates through the books array and copies the values into the temp array
        for(int i = 0; i<books.length; i++){
            temp[i] = books[i];
        }
        //adds the new book at the end of the array, and sets the temporary array back to the original 
        //books array
        temp[books.length] = book;
        books = temp;
    }

    //inserts a book at a specific index
    public void insertBook(Book book, int index){
    //creates a new array
    Book[] copy = new Book[books.length + 1];
    //copies the original books array to the new array until the specific index
        for(int i = 0; i<index; i++){
            copy[i] = books[i];
        }
        //copies the original books array to the new array after the specific index
        for(int i = index+1; i<copy.length;i++ ){
            copy[i] = books[i-1];
        }
        //inserts the book at the specified index
        copy[index] = book;
        books = copy;
        

    }

    //Removes a book from the "books" array
    public void removeBook(Book book){
        int idx = 0; 
        //checks too see if each book is equal to the book in the parameter
        for(int i = 0; i<books.length; i++){
            if(book == books[i]){
                idx = i;
            }
        }
        //if the quantity of the book is equal to 1,
        //it will copy the books in bookList, but skip over the removed book
        if(books[idx].getQuantity()==1){
            Book[] copy = new Book[books.length-1];
            for(int i = 0; i<idx; i++){
                copy[i] = books[i];
            }
            for(int i = idx +1; i<books.length; i++){
                copy[i-1] = books[i];
            }
            books = copy;
        } else {
            //if the quantity of the book is not equal to 1,
            //the program will lower the quantity by 1
            books[idx].setQuantity(books[idx].getQuantity()-1);
        }
    }

    //returns a string containing all the information about each book in the "books" array
    public String bookStoreBookInfo(){
        String str = "";
        for(int i = 0; i<books.length; i++){
            str+=books[i].bookInfo() + "\n";
        }
        return str;
    }

    //returns a string containing all the information about each user in the "users" array
    public String bookStoreUserInfo(){
        String str = "";
        //iterates through all of the users in the array that aren't empty
        for(int i = 0; i<users.length; i++){
            if(users[i]!=null){
                //adds the information to a string and returns the final string.
                str+=users[i].userInfo() + "\n";
            }
        }
        return str;
    }
}

