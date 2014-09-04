/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.CustomerInvoice;
import com.mycompany.carshop.repository.CustomerInvoiceRepository;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.Date;
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
public class CustomerInvoiceTest {
    public static ApplicationContext ctx;
    private Long id;
    private CustomerInvoiceRepository invoiceRepository;
    
    public CustomerInvoiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createInvoice() {
        invoiceRepository = ctx.getBean(CustomerInvoiceRepository.class);
        
        CustomerInvoice invoice = new CustomerInvoice.Builder("20583")
                                        .invoiceDate(new Date())
                                        .orderAmount(new BigDecimal(150.00))
                                        .invoiceStatus("Paid")
                                        .build();
        
        invoiceRepository.save(invoice);
        id = invoice.getId();
        Assert.assertNotNull(invoice);   
    }
    @Test(dependsOnMethods = "createInvoice", enabled = true)
    public void readInvoice()
    {
        invoiceRepository = ctx.getBean(CustomerInvoiceRepository.class);
        CustomerInvoice invoice = invoiceRepository.findOne(id);
        Assert.assertEquals(invoice.getInvoiceNumber(), "20583");
    }
    @Test(dependsOnMethods = "readInvoice", enabled = true)
    public void updateInvoice()
    {
        invoiceRepository = ctx.getBean(CustomerInvoiceRepository.class);
        
        CustomerInvoice invoice = invoiceRepository.findOne(id);
        
        CustomerInvoice updateInvoice = new   CustomerInvoice.Builder("20583")
                                                .customerInvoice(invoice)
                                                .orderAmount(new BigDecimal(200.00))
                                                .build();
                                            
        invoiceRepository.save(updateInvoice);
        
        CustomerInvoice newInvoice = invoiceRepository.findOne(id);
        Assert.assertEquals(newInvoice.getOrderAmount(), new BigDecimal(200.00));
    }
    @Test(dependsOnMethods = "updateInvoice", enabled = true)
    public void deleteInvoice()
    {
         invoiceRepository = ctx.getBean(CustomerInvoiceRepository.class);
        CustomerInvoice invoice = invoiceRepository.findOne(id);
        invoiceRepository.delete(invoice);
        
        CustomerInvoice deletedInvoice = invoiceRepository.findOne(id);
        Assert.assertNull(deletedInvoice);
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
