package com.jumia.test.app.db.service;

import com.jumia.test.app.db.dao.CustomerDao;
import com.jumia.test.app.db.model.DbCustomer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<DbCustomer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
}
