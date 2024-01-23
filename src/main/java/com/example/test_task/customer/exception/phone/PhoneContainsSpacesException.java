package com.example.test_task.customer.exception.phone;

public class PhoneContainsSpacesException extends RuntimeException {
    private static final String PHONE_NUMBER_CONTAIN_SPACES_TEXT = "the phone number: %s contains spaces";

    public PhoneContainsSpacesException(String phone) {
        super(String.format(PHONE_NUMBER_CONTAIN_SPACES_TEXT, phone));
    }
}
