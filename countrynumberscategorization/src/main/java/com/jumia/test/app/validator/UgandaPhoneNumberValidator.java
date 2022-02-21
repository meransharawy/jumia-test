package com.jumia.test.app.validator;

import org.springframework.stereotype.Component;

@Component
public class UgandaPhoneNumberValidator implements PhoneNumberValidator{

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\(256\\)\\s?\\d{9}$");
    }
}