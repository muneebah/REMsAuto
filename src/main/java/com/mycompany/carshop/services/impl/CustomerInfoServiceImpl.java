/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.domain.CustomerAddress;
import com.mycompany.carshop.domain.CustomerContact;
import com.mycompany.carshop.domain.CustomerName;
import com.mycompany.carshop.repository.CustomerRepository;
import com.mycompany.carshop.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class CustomerInfoServiceImpl implements CustomerInfoService{
    
    @Autowired
    private CustomerRepository custRepo;
    
    @Override
    public String getFullName(Long customerID) {
        Customer customer = custRepo.findOne(customerID);
        CustomerName name = customer.getCustomerName();
        return name.getFirstName() + " " + name.getLastName();
    }

    @Override
    public String getStreetAddress(Long customerID) {
       Customer customer = custRepo.findOne(customerID);
        CustomerAddress address = customer.getCustomerAddress();
        return address.getStreetAddress();
    }

    @Override
    public String getCellNumber(Long customerID) {
        Customer customer = custRepo.findOne(customerID);
        CustomerContact contact = customer.getCustomerContact();
        return contact.getCellNumber(); 
    }
    
}
