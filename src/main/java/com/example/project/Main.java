package com.example.project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            BookStore store = new BookStore();
            Scanner scan = new Scanner(System.in);
            int choice = 0;
            System.out.println("++++++++++++++++++++Welcome to Ben's Books++++++++++++++++++++");
            System.out.println("               Select one of the options below:");
            System.out.println("..............................................................");
            while(choice!=9){
                System.out.println("Press 1 to Add new Book\nPress 2 to Update Quantity of a book\nPress 3 to Search a Book\nPress 4 to Show all Books\nPress 5 to Register User\nPress 6 to Show all Registered Users\nPress 7 to Check in Book\nPress 8 to Check out Book\nPress 9 to Exit Application");
                System.out.println("--------------------------------------------------------------");
                choice = scan.nextInt();
                scan.nextLine();  
                if(choice==1){
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
                    Book addedBook = new Book(newTitle,newAuthor,newYear,newISBN,newQuantity);
                    store.addBook(addedBook);
                    System.out.println("--------------------------------------------------------------");
                } else if(choice==2){
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter ISBN of book:");
                    String newI = scan.nextLine();
                    Book bookUpdate = null;
                    for(Book book: store.getBooks()){
                        if(book != null && book.getIsbn().equals(newI)){
                            bookUpdate = book;
                            break;
                        }
                        
                    }
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
                } else if(choice==3){
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter ISBN of book:");
                    String bookSearch = scan.nextLine();
                    Book findBook = null;
                    for(Book book: store.getBooks()){
                        if(book != null && book.getIsbn().equals(bookSearch)){
                            findBook = book;
                            break;
                        }
                    }
                    if(findBook!=null){
                        System.out.println(findBook.bookInfo());
                    } else {
                        System.out.println("Book Not Found");
                    }
                    System.out.println("--------------------------------------------------------------");
                } else if (choice==4){
                    System.out.println("--------------------------------------------------------------");
                    if(store.bookStoreBookInfo().isEmpty())//learned this line of code from https://www.w3schools.com/java/ref_string_isempty.asp
                    { 
                        System.out.println("No Books Found");
                    } else {
                        System.out.println(store.bookStoreBookInfo());
                    }
                    System.out.println("--------------------------------------------------------------");
                } else if (choice==5){
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter Your Name:");
                    String name = scan.nextLine();
                    String newID = IdGenerate.generateID();
                    User newUser = new User(name,newID);
                    store.addUser(newUser);
                    System.out.println(newUser.userInfo());
                    System.out.println("Registration Complete");
                } else if (choice==6){
                    System.out.println("--------------------------------------------------------------");
                    if (store.bookStoreUserInfo().isEmpty()){
                        System.out.println("No Registered Users");
                    } else {
                        System.out.println(store.bookStoreUserInfo());
                    }
                } else if (choice==7){
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter your ID:");
                    String userID = scan.nextLine();
                    System.out.println("Enter Book ISBN:");
                    String bookISBN = scan.nextLine();
                    User findUser = null;
                    Book returnBook = null;
                    for(User user:store.getUsers()){
                        if(user != null && user.getId().equals(userID)){
                            findUser = user;
                            break;
                        }
                    }
                    if(findUser!=null){   
                        for(Book books: store.getBooks()){
                            if(books != null && books.getIsbn().equals(bookISBN)){
                                returnBook = books;
                                break;
                            }
                        }
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
                } else if (choice==8){
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter your ID:");
                    String userID = scan.nextLine();
                    System.out.println("Enter Book ISBN:");
                    String bookISBN = scan.nextLine();
                    User findUser = null;
                    Book checkOutBook = null;
                    for(User user:store.getUsers()){
                        if(user != null && user.getId().equals(userID)){
                            findUser = user;
                            break;
                        }
                    }
                    if(findUser!=null){   
                        for(Book books: store.getBooks()){
                            if(books != null && books.getIsbn().equals(bookISBN) && books.getQuantity()>0){
                                checkOutBook = books;
                                break;
                            }
                        }
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
                } else if(choice==9) {
                    System.out.println("()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()");
                    System.out.println("                Thanks for Using Ben's Books");
                    System.out.println("                          Goodbye!");
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                } else {
                    System.out.println("              Invalid Response\nPlease Try Again");
                    System.out.println("--------------------------------------------------------------");
                }
}
}
}
