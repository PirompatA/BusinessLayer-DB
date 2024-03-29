package com.kbtg.apidesign01.exception;

public class DuplicateWalletException extends RuntimeException{
    public DuplicateWalletException(String message) {
        super(message);
    }
}
