/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.app.conf.ConnectionConfig;
import com.mycompany.carshop.domain.CreditCard;
import com.mycompany.carshop.repository.CreditCardRepository;
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
public class CreditCardRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private CreditCardRepository creditCardRepository;
    
    public CreditCardRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCreditCard() {
        creditCardRepository = ctx.getBean(CreditCardRepository.class);
        
        CreditCard creditCard = new CreditCard.Builder("50361592227975")
                .balance(new BigDecimal(2000.00))
                .expiryDate(new Date())
                .nameOnCreditCard("Baloyi Rhulie")
                .build();
        
        creditCardRepository.save(creditCard);
        id = creditCard.getId();
        Assert.assertNotNull(creditCard);

    }

    @Test(dependsOnMethods = "createCreditCard", enabled = true)
    public void readCreditCard() {
        creditCardRepository = ctx.getBean(CreditCardRepository.class);
        CreditCard creditcard = creditCardRepository.findOne(id);
        Assert.assertEquals(creditcard.getNameOnCreditCard(), "Baloyi Rhulie");

    }

    @Test(dependsOnMethods = "readCreditCard", enabled = true)
    private void updateCreditCard() {
        creditCardRepository = ctx.getBean(CreditCardRepository.class);

        CreditCard creditCard = creditCardRepository.findOne(id);
        
        CreditCard updatedCreditCard = new CreditCard.Builder("50361592227975")
                .CreditCard(creditCard)
                .nameOnCreditCard("Salvatore Stefan")
                .build();

        creditCardRepository.save(updatedCreditCard);
        CreditCard newCreditCard = creditCardRepository.findOne(id);
        Assert.assertEquals(newCreditCard.getNameOnCreditCard(), "Salvatore Stefan");

    }

    @Test(dependsOnMethods = "updateCreditCard", enabled = false)
    private void deleteCreditCard() {

        creditCardRepository = ctx.getBean(CreditCardRepository.class);
        
        CreditCard card = creditCardRepository.findOne(id);        
        creditCardRepository.delete(card);
  
        CreditCard deletedCreditCard = creditCardRepository.findOne(id);
        Assert.assertNull(deletedCreditCard);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
          ctx =  new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
