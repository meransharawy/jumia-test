package com.jumia.test.app.controller;

import com.jumia.test.app.db.facade.CustomerFacade;
import com.jumia.test.app.model.Customer;
import com.jumia.test.app.model.FilterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
public class CustomerController {

    @Autowired
    CustomerFacade customerFacade;

    @GetMapping("/customers")
    @CrossOrigin(origins = "http://localhost:8888")
    public List<Customer> getAllCustomers() throws Exception {
        return customerFacade.getAllCustomers();

    }

    @PostMapping("/customers/filter")
    @CrossOrigin(origins = "http://localhost:8888")
    public List<Customer> getFilteredCustomers(@RequestBody FilterModel filterModel) throws Exception {
        return customerFacade.getFilteredCustomers(filterModel);
    }
}
