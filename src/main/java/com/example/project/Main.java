package com.example.project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            //creates the BookStore object store
            BookStore store = new BookStore();
            //creates scanner object
            Scanner scan = new Scanner(System.in);
            int choice = 10;
            System.out.println("++++++++++++++++++++Welcome to Ben's Books++++++++++++++++++++");
            System.out.println("               Select one of the options below:");
            System.out.println("..............................................................");
            //Will keep running the program until the user enters 9
            while(choice!=0){
                //Will ask for the users input
                System.out.println("Press 1 to Add new Book\nPress 2 to Remove Book\nPress 3 to Update Quantity of a book\nPress 4 to Search a Book\nPress 5 to Show all Books\nPress 6 to Register User\nPress 7 to Show all Registered Users\nPress 8 to Check in Book\nPress 9 to Check out Book\nPress 0 to Exit Application");
                System.out.println("--------------------------------------------------------------");
                choice = scan.nextInt();
                scan.nextLine();  
                if(choice==1){
                    //asks the user for all of the information of the new book
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter Serial Number of Book:");
                    String newISBN = scan.nextLine();
                    System.out.println("Enter Name of Book:");
                    String newTitle = scan.nextLine();
                    System.out.println("Enter Name of Author:");
                    String newAuthor = scan.nextLine();
                    System.out.println("Enter the Year Book was Published:");
                    int newYear = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Quantity of Books:");
                    int newQuantity = scan.nextInt();
                    scan.nextLine();
                    //creates a new book object
                    Book addedBook = new Book(newTitle,newAuthor,newYear,newISBN,newQuantity);
                    //adds the book to the book store
                    store.addBook(addedBook);
                    System.out.println("--------------------------------------------------------------");
                } else if(choice==2){
                    //Asks user for ISBN of Book
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter ISBN of book:");
                    String bookSearch = scan.nextLine();
                    Book findBook = null;
                    //Iterates through the BookStore and identifies the book equal to the provided ISBN
                    for(Book book: store.getBooks()){
                        if(book != null && book.getIsbn().equals(bookSearch)){
                            findBook = book;
                            break;
                        }
                    }
                    //If the book is found, it will remove 1 book from the quantity
                    if(findBook!=null){
                        store.removeBook(findBook);
                        System.out.println("Book Removed");

                    } else {
                        //otherwise it will print out "Book Not Found"
                        System.out.println("Book Not Found");
                    }
                    System.out.println("--------------------------------------------------------------");
                }else if(choice==3){
                    //asks the user for the ISBN of the book
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter ISBN of book:");
                    String newI = scan.nextLine();
                    Book bookUpdate = null;
                    //Iterates through the BookStore and identifies the book equal to the provided ISBN
                    for(Book book: store.getBooks()){
                        if(book != null && book.getIsbn().equals(newI)){
                            bookUpdate = book;
                            break;
                        }
                        
                    }
                    //If the book is found it will prompt the user to enter the new quantity of books
                    //and will increase the quantity to that number
                    if(bookUpdate!=null){
                        System.out.println("Enter new Quantity of Book:");
                        int newQ = scan.nextInt();
                        scan.nextLine();
                        if(newQ==bookUpdate.getQuantity()){
                            System.out.println("Same Number of books");
                        } else{
                            bookUpdate.setQuantity(newQ);
                            System.out.println("Book Quantity Updated");
                        }
                    } else{
                        System.out.println("Book Not Found");
                    }
                    System.out.println("--------------------------------------------------------------");
                } else if(choice==4){
                    //asks the user for the ISBN of the book
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter ISBN of book:");
                    String bookSearch = scan.nextLine();
                    Book findBook = null;
                    //Iterates through the BookStore and identifies the book equal to the provided ISBN
                    for(Book book: store.getBooks()){
                        if(book != null && book.getIsbn().equals(bookSearch)){
                            findBook = book;
                            break;
                        }
                    }
                    //If the book is found it will provide the information of that book
                    if(findBook!=null){
                        System.out.println(findBook.bookInfo());
                    } else {
                        System.out.println("Book Not Found");
                    }
                    System.out.println("--------------------------------------------------------------");
                } else if (choice==5){
                    //if the store array is empty, it will print out "No Books Found"
                    System.out.println("--------------------------------------------------------------");
                    if(store.bookStoreBookInfo().isEmpty())//learned this line of code from https://www.w3schools.com/java/ref_string_isempty.asp
                    { 
                        System.out.println("No Books Found");
                    } else {
                        //otherwise it will display all of the information about
                        //each of the books in BookStore store
                        System.out.println(store.bookStoreBookInfo());
                    }
                    System.out.println("--------------------------------------------------------------");
                } else if (choice==6){
                    //Will prompt the user to enter their name
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter Your Name:");
                    String name = scan.nextLine();
                    //creates a new ID for the user
                    String newID = IdGenerate.generateID();
                    //creates a new User object with the provided name and new generated ID
                    User newUser = new User(name,newID);
                    store.addUser(newUser);
                    //will display the current information about the user
                    System.out.println(newUser.userInfo());
                    System.out.println("Registration Complete");
                } else if (choice==7){                    
                    System.out.println("--------------------------------------------------------------");
                    //if the users array is empty, it will print out "No Registered Users"
                    if (store.bookStoreUserInfo().isEmpty()){
                        System.out.println("No Registered Users");
                    } else {
                        //otherwise it will display all of the information about
                        //each of the users in User array
                        System.out.println(store.bookStoreUserInfo());
                    }
                } else if (choice==8){
                    //Prompts the user to enter their ID and the book's ISBN
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter your ID:");
                    String userID = scan.nextLine();
                    System.out.println("Enter Book ISBN:");
                    String bookISBN = scan.nextLine();
                    User findUser = null;
                    Book returnBook = null;
                    //It will iterate through the Users array to identify the user with the 
                    //identical ID as the one provided
                    for(User user:store.getUsers()){
                        if(user != null && user.getId().equals(userID)){
                            findUser = user;
                            break;
                        }
                    }
                    //If the correct user if found
                    //It will iterate through the all of the books
                    //to identify the book with the same ISBN as the book provided
                    if(findUser!=null){   
                        for(Book books: store.getBooks()){
                            if(books != null && books.getIsbn().equals(bookISBN)){
                                returnBook = books;
                                break;
                            }
                        }
                        //If the correct book is found
                        //It will increase the book's quantity by 1
                        //and display "Book checked in"
                        if(returnBook!=null){
                            for (Book book : store.getBooks()) {
                                if (book != null && book.getIsbn().equals(bookISBN)) {
                                        book.setQuantity(book.getQuantity() + 1);
                                        System.out.println("Book checked in");
                                        break;
                                }                   
                            }
                            } else {
                                System.out.println("Invalid Book");
                            }
                    } else {
                        System.out.println("No User Found");
                    }
                        System.out.println("--------------------------------------------------------------");
                } else if (choice==9){
                    //Prompts the user to enter the User's ID and the Book's ISBN
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter your ID:");
                    String userID = scan.nextLine();
                    System.out.println("Enter Book ISBN:");
                    String bookISBN = scan.nextLine();
                    User findUser = null;
                    Book checkOutBook = null;
                    //It will iterate through the Users array to identify the user with the 
                    //identical ID as the one provided
                    for(User user:store.getUsers()){
                        if(user != null && user.getId().equals(userID)){
                            findUser = user;
                            break;
                        }
                    }
                    //If the correct user if found
                    //It will iterate through the all of the books
                    //to identify the book with the same ISBN as the book provided
                    if(findUser!=null){   
                        for(Book books: store.getBooks()){
                            if(books != null && books.getIsbn().equals(bookISBN) && books.getQuantity()>0){
                                checkOutBook = books;
                                break;
                            }
                        }
                        //If the correct book is found
                        //it will decrease the quantity by 1
                        //and display "Book Checked Out"
                        if(checkOutBook!=null){  
                            for(int i = 0; i<findUser.getBooks().length; i++){
                                if(findUser.getBooks()[i]==null){
                                    findUser.getBooks()[i] = checkOutBook;
                                    checkOutBook.setQuantity(checkOutBook.getQuantity()-1);
                                    System.out.println("Book Checked Out");
                                    break;
                                }
                            } 
                    }else {
                        System.out.println("No Books Found");
                    }
                    } else {
                        System.out.println("No User Found");
                    }
                    System.out.println("--------------------------------------------------------------");
                } else if(choice==0) {
                    //Will Display the closing message for the program
                    System.out.println("()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()");
                    System.out.println("                Thanks for Using Ben's Books");
                    System.out.println("                          Goodbye!");
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                } else {
                    System.out.println("              Invalid Response\nPlease Try Again");
                    System.out.println("--------------------------------------------------------------");
                }
}
scan.close();
}
}
