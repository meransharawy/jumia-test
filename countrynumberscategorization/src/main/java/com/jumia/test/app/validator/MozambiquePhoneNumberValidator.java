package com.jumia.test.app.validator;

import org.springframework.stereotype.Component;

@Component
public class MozambiquePhoneNumberValidator implements PhoneNumberValidator{

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\(258\\)\\s?[28]\\d{7,8}$");
    }
}
