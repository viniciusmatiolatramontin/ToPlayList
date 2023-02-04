package com.toplaylist.to_play_list.exceptions;

public class PublisherNotFoundException extends RuntimeException {

    public PublisherNotFoundException(String arg0) {
        super(arg0);
    }

    public PublisherNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
