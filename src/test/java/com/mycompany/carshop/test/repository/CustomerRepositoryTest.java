/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.CreditCard;
import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.domain.CustomerAddress;
import com.mycompany.carshop.domain.CustomerContact;
import com.mycompany.carshop.domain.CustomerName;
import com.mycompany.carshop.domain.Demographic;
import com.mycompany.carshop.repository.CreditCardRepository;
import com.mycompany.carshop.repository.CustomerRepository;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Elton
 */
public class CustomerRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private CustomerRepository customerRepository;
    private CreditCardRepository creditCardRepository;
    
    public CustomerRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test(enabled = true)
    public void createCustomer() {
        customerRepository = ctx.getBean(CustomerRepository.class);
        creditCardRepository = ctx.getBean(CreditCardRepository.class);
        
        CustomerName customerName = new CustomerName();
        customerName.setFirstName("Rhulani");
        customerName.setLastName("Baloyi");
        
        CustomerContact contact = new CustomerContact();
        contact.setCellNumber("0799414940");
        contact.setPhoneNumber("0215558379");
        
        Demographic demo = new Demographic();
        demo.setDateOfBirth(new Date());
        demo.setGender("Female");
        demo.setRace("White");
        
        CustomerAddress address = new CustomerAddress();
        address.setStreetAddress("17 summer street");
        address.setPostalAddress("7100");
     
        CreditCard creditCard1 = new CreditCard.Builder("98765412308")
                .balance(new BigDecimal(3000.00))
                .expiryDate(new Date())
                .nameOnCreditCard("Messi")
                .build();
        
        //creditCardRepository.save(creditCard1);
                
        CreditCard creditCard2 = new CreditCard.Builder("789654123056")
                .balance(new BigDecimal(4000.00))
                .expiryDate(new Date())
                .nameOnCreditCard("Neymar")
                .build();
        
        //creditCardRepository.save(creditCard2);
        
        List<CreditCard> creditCards = new ArrayList<CreditCard>();
        creditCards.add(creditCard1);
        creditCards.add(creditCard2);
        
        Customer customer = new Customer.Builder("10000")
                .customerName(customerName)
                .customerContact(contact)
                .demographic(demo)
                .customerAddress(address)
                .creditCard(creditCards)
                .build();
        customerRepository.save(customer);
        id = customer.getId();
        
        Assert.assertNotNull(customer);
    }

    @Test(dependsOnMethods = "createCustomer", enabled = true)
    public void readCustomer() {
        customerRepository = ctx.getBean(CustomerRepository.class);
        Customer customer = customerRepository.findOne(id);
        Assert.assertEquals(customer.getCustomerNumber(), "10000");
    }

    @Test(dependsOnMethods = "readCustomer", enabled = true)
    private void updateCustomer() {
        customerRepository = ctx.getBean(CustomerRepository.class);
        
        CustomerName customerName = new CustomerName();
        customerName.setFirstName("Lionel");
        customerName.setLastName("Salvatore");
        
        
        Customer customer = customerRepository.findOne(id);
        Customer updateCustomer = new Customer.Builder("10000")
                .customer(customer)
                .customerName(customerName)
                .build();
        customerRepository.save(updateCustomer);
        
        Customer newCustomer = customerRepository.findOne(id);
        CustomerName updateName = newCustomer.getCustomerName();
        Assert.assertEquals(updateName.getFirstName(), "Lionel");

    }

    @Test(dependsOnMethods = "updateCustomer", enabled = false)
    private void deleteCustomer() {

        customerRepository = ctx.getBean(CustomerRepository.class);
        Customer customer = customerRepository.findOne(id);
        customerRepository.delete(customer);
        Customer deletedCustomer = customerRepository.findOne(id);
        
        Assert.assertNull(deletedCustomer);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = (ApplicationContext) new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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