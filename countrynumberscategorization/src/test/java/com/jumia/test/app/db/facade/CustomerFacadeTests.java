package com.jumia.test.app.db.facade;

import com.jumia.test.app.db.model.DbCustomer;
import com.jumia.test.app.db.service.CustomerService;
import com.jumia.test.app.model.Customer;
import com.jumia.test.app.model.FilterModel;
import com.jumia.test.app.utils.ModelsConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
class CustomerFacadeTests {

    @Autowired
    CustomerFacade customerFacade;

    @MockBean
    CustomerService customerService;

    @MockBean
    ModelsConverter modelsConverter;

    @Test
    void getAllCustomers_Success()  {

        List<DbCustomer> dbCustomers = new ArrayList<>();
        dbCustomers.add(DbCustomer.builder().name("meran").phone("(212) 6007989253").id(0).build());

        when(customerService.getAllCustomers()).thenReturn(dbCustomers);
        when(modelsConverter.mapDbCustomerToCustomer(any())).thenReturn(Customer.builder().customerName("meran").countryCode("212")
                .state(false).phoneNumber("(212) 6007989253").countryName("Morocco").build());

        assertNotNull(customerFacade.getAllCustomers());
    }

    @Test
    void getFiltredCustomers_Success()  {

        List<DbCustomer> dbCustomers = new ArrayList<>();
        dbCustomers.add(DbCustomer.builder().name("meran").phone("(256) 7503O6263").id(0).build());

        when(customerService.getAllCustomers()).thenReturn(dbCustomers);
        when(modelsConverter.mapDbCustomerToCustomer(any())).thenReturn(Customer.builder().customerName("meran").countryCode("256")
                .state(false).phoneNumber("(256) 7503O6263").countryName("Uganda").build());

        List<Customer>  filteredCustomers =customerFacade.getFilteredCustomers(FilterModel.builder().countryName("Uganda").state(false).build());
        assertNotNull(filteredCustomers);
        assertEquals("Uganda", filteredCustomers.get(0).getCountryName());
    }
}
