package com.example.test_task.customer.exception.email;

public class EmailContainsSpacesException extends RuntimeException{
    private static final String EMAIL_CONTAIN_SPACES_TEXT = "email: %s contains spaces";

    public EmailContainsSpacesException(String email) {
        super(String.format(EMAIL_CONTAIN_SPACES_TEXT, email));
    }
}
