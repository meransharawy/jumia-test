package com.jumia.test.app.validator;

import org.springframework.stereotype.Component;

@Component
public class MoroccoPhoneNumberValidator implements PhoneNumberValidator{

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\(212\\)\\s?[5-9]\\d{8}$");
    }
}
