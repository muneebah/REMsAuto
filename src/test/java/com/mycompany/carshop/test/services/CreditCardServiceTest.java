/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.app.exceptions.CreditCardRejectionException;
import com.mycompany.carshop.domain.CreditCard;
import com.mycompany.carshop.repository.CreditCardRepository;
import com.mycompany.carshop.services.CreditCardService;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.Date;
import org.joda.time.DateTime;
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
public class CreditCardServiceTest {
    public static ApplicationContext ctx;
    private Long id;
    private CreditCardService creditService;
    private CreditCardRepository creditCardRepository;
    
    public CreditCardServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void testForCreditApproval() {
        creditService = ctx.getBean(CreditCardService.class);
        creditCardRepository = ctx.getBean(CreditCardRepository.class);

        Date expiryDate = new DateTime(2014, 12, 26, 0, 0).toDate();

        CreditCard creditCard = new CreditCard.Builder("503615922279")
                .balance(new BigDecimal(20000.00))
                .expiryDate(expiryDate)
                .nameOnCreditCard("Mrs R.Baloyi")
                .build();

        id = creditCard.getId();
        creditCardRepository.save(creditCard);
   
        Assert.assertNotNull(creditCard);
        String status = creditService.processPayment("503615922279", new BigDecimal("1900.00"), expiryDate);
        Assert.assertEquals(status, "APPROVED");

    }

    @Test(expectedExceptions = CreditCardRejectionException.class, enabled = false)
    public void testForWrongCreditCardNumber() {
        creditService = ctx.getBean(CreditCardService.class);
        creditCardRepository = ctx.getBean(CreditCardRepository.class);

        Date expiryDate = new DateTime(2014, 12, 26, 0, 0).toDate();

        CreditCard creditCard = new CreditCard.Builder("20102011")
                .balance(new BigDecimal(20000.00))
                .expiryDate(expiryDate)
                .nameOnCreditCard("Mrs R.Baloyi")
                .build();
        
        creditCardRepository.save(creditCard);
        Assert.assertNotNull(creditCard);
        String status = creditService.processPayment("20102011", new BigDecimal("1900.00"), expiryDate);
        Assert.assertEquals(status, "Wrong CreditCard Number");

    }

    @Test(expectedExceptions = CreditCardRejectionException.class, enabled = true)
    public void testForWrongCreditCardExpiryDate() {
        
        creditService = ctx.getBean(CreditCardService.class);
        creditCardRepository = ctx.getBean(CreditCardRepository.class);

        Date expiryDate = new DateTime(2012, 12, 26, 0, 0).toDate();

        CreditCard creditCard = new CreditCard.Builder("808691")
                .balance(new BigDecimal(20000.00))
                .expiryDate(expiryDate)
                .nameOnCreditCard("MR L. Baloyi")
                .build();

        creditCardRepository.save(creditCard);
        Assert.assertNotNull(creditCard);

        Date wrongDate = new DateTime(2016, 12, 26, 0, 0).toDate();
        String status = creditService.processPayment("919520", new BigDecimal("1900.00"), wrongDate);
         Assert.assertEquals(status, "Wrong CreditCard Expiry Date");
    }

    @Test(expectedExceptions = CreditCardRejectionException.class, enabled = true)
    public void testForInsufficientbalance() {
        creditCardRepository = ctx.getBean(CreditCardRepository.class);
        creditService = ctx.getBean(CreditCardService.class);
        
        Date expiryDate = new DateTime(2012, 12, 26, 0, 0).toDate();


        CreditCard creditCard = new CreditCard.Builder("123456")
                .balance(new BigDecimal(20000.00))
                .expiryDate(expiryDate)
                .nameOnCreditCard("miss paulsen")
                .build();
        
        creditCardRepository.save(creditCard);
        
        Assert.assertNotNull(creditCard);

        
        String status = creditService.processPayment("543216", new BigDecimal("40000.00"), expiryDate);
        Assert.assertEquals(status, "Insufficient balance");
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
