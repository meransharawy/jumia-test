package com.jumia.test.app.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class CameroonPhoneNumberValidatorTests {

    @Autowired
    CameroonPhoneNumberValidator cameroonPhoneNumberValidator;

    @Test
    void validateMobileNumber_Success_returnFalse() throws IllegalArgumentException {

        Boolean valid = cameroonPhoneNumberValidator.validatePhoneNumber("(251) 9773199405");
        assertEquals(false, valid);

    }
}
