package org.loose.fis.sre.exceptions;

public class InvalidUser extends Exception{
    public InvalidUser(){
        super("User does not exist");
    }
}
