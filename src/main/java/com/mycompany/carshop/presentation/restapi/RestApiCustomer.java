/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.presentation.restapi;

import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Rhulani Steff Baloyi
 */

@Controller
@RequestMapping("api")
public class RestApiCustomer {
    
    @Autowired
    private CustomerRepository customerService;
    
    @RequestMapping("customer")
    @ResponseBody
    public List<Customer> getCustomer(){
        return customerService.findAll();
    }
    
}
