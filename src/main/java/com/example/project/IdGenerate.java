package com.example.project;

public class IdGenerate{ 
    
    //static string attribute initialized to 99, keeps track of the current Id number
    private static String currentId = "99";

    //empty constructor
    public IdGenerate(){ }

    // returns the static variable currentId
    public static String getCurrentId(){
        return currentId;
    }

    //resets the static variable currentId back to 99
    public static void reset(){
        currentId = "99";
    }

    /*creates a new Id
      increases the currentId by 1 each time an Id is created*/
    public static void generateID(){
        //converts the String currentId into an integer 
        int newValue = Integer.valueOf(currentId) +1; // Found the valueOf line from https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
        //and back to a string
        currentId = "" + newValue;
    }
}