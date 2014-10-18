/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.domain.CreditCard;
import com.mycompany.carshop.domain.CustomerInvoice;
import com.mycompany.carshop.repository.CreditCardRepository;
import com.mycompany.carshop.repository.CustomerInvoiceRepository;
import com.mycompany.carshop.services.ProcessInvoicesService;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mhumhu
 */
public class ProcessInvoicesServiceTest {
    private ProcessInvoicesService processInvoicesService;
    private CreditCardRepository creditCardService;
    private CustomerInvoiceRepository customerInvoiceService;
    private static ApplicationContext ctx;
    
    public ProcessInvoicesServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testProcessInvoicesService() {
        processInvoicesService = ctx.getBean(ProcessInvoicesService.class);
        creditCardService = ctx.getBean(CreditCardRepository.class);
        customerInvoiceService = ctx.getBean(CustomerInvoiceRepository.class);
        
        List<CreditCard> creditCards = creditCardService.findAll();
        CreditCard creditCard = creditCards.get(0);
        double balance = creditCard.getBalance().doubleValue();     
       
        List<CustomerInvoice> invoices = customerInvoiceService.findAll();
        CustomerInvoice invoice = invoices.get(0);
        processInvoicesService.processInvoice(invoice.getId());
        
        creditCard = creditCards.get(0);
        balance -= 100;
        Assert.assertEquals(balance,creditCard.getBalance().doubleValue(),0); 
        
        CustomerInvoice invoice2 = customerInvoiceService.findOne(invoice.getId());
        Assert.assertEquals("PAID",invoice2.getInvoiceStatus());  
        
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
