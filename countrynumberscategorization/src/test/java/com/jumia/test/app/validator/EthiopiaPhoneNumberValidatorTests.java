package com.jumia.test.app.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class EthiopiaPhoneNumberValidatorTests {

    @Autowired
    EthiopiaPhoneNumberValidator ethiopiaPhoneNumberValidator;

    @Test
    void validateMobileNumber_Success_returnFalse() throws IllegalArgumentException {

        Boolean valid = ethiopiaPhoneNumberValidator.validatePhoneNumber("(251) 911203317");
        assertEquals(false, valid);

    }

}
