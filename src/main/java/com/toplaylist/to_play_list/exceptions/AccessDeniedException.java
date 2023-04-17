package com.toplaylist.to_play_list.exceptions;

public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(String arg0) {
        super(arg0);
    }

    public AccessDeniedException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    
}
