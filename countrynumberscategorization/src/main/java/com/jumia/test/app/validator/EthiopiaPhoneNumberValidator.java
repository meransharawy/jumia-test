package com.jumia.test.app.validator;

import org.springframework.stereotype.Component;

@Component
public class EthiopiaPhoneNumberValidator implements PhoneNumberValidator{

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\(237\\)\\s?[2368]\\d{7,8}$");
    }
}
