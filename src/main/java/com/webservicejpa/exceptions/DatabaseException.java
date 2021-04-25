package com.webservicejpa.exceptions;

import java.io.Serializable;

public class DatabaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public DatabaseException() {
    }

    public DatabaseException(String msg) {
        super(msg);
    }
}
