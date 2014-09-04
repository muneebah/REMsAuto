/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.CustomerAddress;
import com.mycompany.carshop.repository.CustomerAddressRepository;
import com.mycompany.carshop.test.ConnectionConfigTest;
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
public class CustomerAddressRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private CustomerAddressRepository repo;
    
    public CustomerAddressRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCustomerAddress() {
     repo = ctx.getBean(CustomerAddressRepository.class);
     
     CustomerAddress address = new CustomerAddress.Builder("17 summer street")
                                    .postalAddress("7100")
                                    .build();
     
     repo.save(address);
     id = address.getId();
     Assert.assertNotNull(address);
    }
    
    @Test(dependsOnMethods = "createCustomerAddress", enabled = true)
    public void readCustomerAddress()
    {
        repo = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress address = repo.findOne(id);
        Assert.assertEquals(address.getStreetAddress(), "17 summer street");
    }
    @Test(dependsOnMethods = "readCustomerAddress", enabled = true)
    public void updateCustomerAddress()
    {
        repo = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress address = repo.findOne(id);
        
        CustomerAddress updateAddress = new CustomerAddress.Builder("17 summer street")
                                            .customerAddress(address)
                                            .postalAddress("7101")
                                            .build();
        repo.save(updateAddress);
        
        CustomerAddress newAddress = repo.findOne(id);
        Assert.assertEquals(newAddress.getPostalAddress(), "7101");
    }
    @Test(dependsOnMethods = "updateCustomerAddress", enabled = true)
    public void deleteCustomerAddress()
    {
        repo = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress address = repo.findOne(id);
        repo.delete(address);
        
        CustomerAddress deletedAddress = repo.findOne(id);
        Assert.assertNull(deletedAddress);
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
