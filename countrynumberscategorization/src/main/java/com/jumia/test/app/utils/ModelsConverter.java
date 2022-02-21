package com.jumia.test.app.utils;

import com.jumia.test.app.constants.CountryConstants;
import com.jumia.test.app.db.model.DbCustomer;
import com.jumia.test.app.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class ModelsConverter {

    public Customer mapDbCustomerToCustomer(DbCustomer dbCustomer) throws IllegalArgumentException {

        Customer customer= new Customer();
        customer.setCustomerName(dbCustomer.getName());
        customer.setPhoneNumber(dbCustomer.getPhone());
        customer.setCountryCode(dbCustomer.getPhone()
                .substring(dbCustomer.getPhone().indexOf('(')+1,dbCustomer.getPhone().indexOf(')')));
        customer.setCountryName(CountryConstants.getCountryNamesMap().get(customer.getCountryCode()));
        if(CountryConstants.getCountriesValidatorsMap().get(customer.getCountryCode()) !=null)
        {
            customer.setState(CountryConstants.getCountriesValidatorsMap().get(customer.getCountryCode())
                .validatePhoneNumber(customer.getPhoneNumber()));
        }else{
            throw new IllegalArgumentException(" country code doesn't exist ");
        }
        return customer;
    }
}
