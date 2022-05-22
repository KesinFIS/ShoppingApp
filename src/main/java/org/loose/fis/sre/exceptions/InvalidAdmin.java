package org.loose.fis.sre.exceptions;

public class InvalidAdmin extends Exception {
    public InvalidAdmin(){
        super("Admin does not exist");
    }
}
