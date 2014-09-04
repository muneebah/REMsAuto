/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.repository.CustomerRepository;
import com.mycompany.carshop.services.CustomerInfoService;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mhumhu
 */
public class CustomerInfoServiceTest {
    public static ApplicationContext ctx;
    private Long id;
    private CustomerInfoService customerService;
    private CustomerRepository custRepository;
    
    public CustomerInfoServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void getCustomerAddress() {
        
        customerService = ctx.getBean(CustomerInfoService.class);
        custRepository = ctx.getBean(CustomerRepository.class);
        
        
        List<Customer> customers = custRepository.findAll();
        
        Customer customer = customers.get(0);
        String name = customerService.getFullName(customer.getId());
        Assert.assertEquals("Joe" + "Doe",name);
        
        String address = customerService.getStreetAddress(customer.getId());
        Assert.assertEquals("17 summer street",address);
        
        String cell = customerService.getCellNumber(customer.getId());
        Assert.assertEquals("0799414940",cell);
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
