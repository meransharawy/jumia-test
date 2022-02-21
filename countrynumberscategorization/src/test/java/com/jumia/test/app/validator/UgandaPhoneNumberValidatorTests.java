package com.jumia.test.app.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class UgandaPhoneNumberValidatorTests {

    @Autowired
    UgandaPhoneNumberValidator ugandaPhoneNumberValidator;

    @Test
    void validateMobileNumber_Success_returnFalse() throws IllegalArgumentException {

        Boolean valid = ugandaPhoneNumberValidator.validatePhoneNumber("(256) 7503O6263");
        assertEquals(false, valid);

    }

    @Test
    void validateMobileNumber_Success_returnTrue() throws IllegalArgumentException {

        Boolean valid = ugandaPhoneNumberValidator.validatePhoneNumber("(256) 775069443");
        assertEquals(true, valid);

    }
}
