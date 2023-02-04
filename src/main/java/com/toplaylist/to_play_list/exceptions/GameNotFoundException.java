package com.toplaylist.to_play_list.exceptions;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(String arg0) {
        super(arg0);
    }

    public GameNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
