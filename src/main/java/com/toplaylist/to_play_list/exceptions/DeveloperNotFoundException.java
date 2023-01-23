package com.toplaylist.to_play_list.exceptions;

public class DeveloperNotFoundException extends RuntimeException{

    public DeveloperNotFoundException(String arg0) {
        super(arg0);
    }

    public DeveloperNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    
}
