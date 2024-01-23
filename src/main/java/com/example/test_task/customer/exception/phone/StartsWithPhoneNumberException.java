package com.example.test_task.customer.exception.phone;

public class StartsWithPhoneNumberException extends RuntimeException{
    private static final String NOT_STARTS_WITH_PLUS_MESSAGE = "the phone number: %s isn't starts with '+'";

    public StartsWithPhoneNumberException(String phone){
        super(String.format(NOT_STARTS_WITH_PLUS_MESSAGE, phone));
    }
}
