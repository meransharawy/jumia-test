package com.jumia.test.app.controller;

import com.jumia.test.app.db.facade.CustomerFacade;
import com.jumia.test.app.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CustomerController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerControllerTests {

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private CustomerController customerController;

    @MockBean
    private CustomerFacade customerFacade;

    @Test
    void getAllCustomers_Expect200() throws Exception {

        List<Customer> customers = new ArrayList<>();
        Customer customer = Customer.builder().customerName("meran"
        ).countryCode("020").phoneNumber("(020) 1063009917").countryName("Egypt").state(true).build();
        customers.add(customer);
        when(customerFacade.getAllCustomers()).thenReturn(customers);

        this.mvc.perform(get("http://localhost:8181/customers")
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(result -> {
                    Assertions.assertThat(result.getResponse().getContentAsString())
                            .isEqualTo("[{\"customerName\":\"meran\",\"phoneNumber\":\"(020) 1063009917\",\"countryName\":\"Egypt\",\"countryCode\":\"020\",\"state\":true}]");
                    Assertions.assertThat(result.getResponse().getStatus())
                            .isEqualTo(HttpStatus.OK.value());
                });
        ;
    }
}
