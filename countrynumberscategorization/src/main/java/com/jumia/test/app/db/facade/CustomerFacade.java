package com.jumia.test.app.db.facade;


import com.jumia.test.app.db.service.CustomerService;
import com.jumia.test.app.db.model.DbCustomer;
import com.jumia.test.app.model.Customer;
import com.jumia.test.app.model.FilterModel;
import com.jumia.test.app.utils.ModelsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerFacade {

    private final CustomerService customerService;

    @Autowired
    ModelsConverter modelsConverter;

    public CustomerFacade(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomers()  {

        List<DbCustomer> dbCustomers=  customerService.getAllCustomers();
        List<Customer> customers = new ArrayList<>();
        for(DbCustomer dbCustomer : dbCustomers){
            customers.add(modelsConverter.mapDbCustomerToCustomer(dbCustomer));
        }
        return customers;
    }

    public List<Customer> getFilteredCustomers(FilterModel filterModel)  {

        List<Customer> allCustomers=  getAllCustomers();
        List<Customer> filteredCustomers = new ArrayList<>();
        for(Customer customer: allCustomers){
            if((filterModel.getCountryName() !=null && filterModel.getState()!=null &&
                    customer.getCountryName().equals(filterModel.getCountryName())
                    && customer.getState().equals(filterModel.getState()))
                    || (filterModel.getCountryName() !=null && filterModel.getState()==null &&
                    customer.getCountryName().equals(filterModel.getCountryName()))
                    ||(filterModel.getCountryName() ==null && filterModel.getState()!=null &&
                    customer.getState().equals(filterModel.getState()))){
                filteredCustomers.add(customer);
            }
        }
        return filteredCustomers;
    }
}
