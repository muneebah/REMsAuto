/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.CreditCard;
import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.domain.CustomerAddress;
import com.mycompany.carshop.domain.CustomerContact;
import com.mycompany.carshop.domain.CustomerInvoice;
import com.mycompany.carshop.domain.CustomerName;
import com.mycompany.carshop.domain.Demographic;
import com.mycompany.carshop.domain.Orders;
import com.mycompany.carshop.domain.OrderItem;
import com.mycompany.carshop.repository.CreditCardRepository;
import com.mycompany.carshop.repository.CustomerInvoiceRepository;
import com.mycompany.carshop.repository.CustomerRepository;
import com.mycompany.carshop.repository.OrderItemRepository;
import com.mycompany.carshop.repository.OrderRepository;
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
 * @author Mhumhu
 */
public class OrderRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private OrderRepository orderRepository;
    private OrderItemRepository itemRepository;
    private CustomerRepository customerRepository;
      private CreditCardRepository creditCardRepository;     
      private CustomerInvoiceRepository invoiceRepository;
      
    public OrderRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createOrder() {
       
        orderRepository = ctx.getBean(OrderRepository.class);
        itemRepository = ctx.getBean(OrderItemRepository.class);
        customerRepository = ctx.getBean(CustomerRepository.class);
        creditCardRepository = ctx.getBean(CreditCardRepository.class);
        invoiceRepository = ctx.getBean(CustomerInvoiceRepository.class);
        
        CustomerName customerName = new CustomerName();
        customerName.setFirstName("Rhulani");
        customerName.setLastName("Baloyi");
        
        CustomerContact contact = new CustomerContact();
        contact.setCellNumber("0799414940");
        contact.setPhoneNumber("0215558379");
        
        Demographic demo = new Demographic();
        demo.setDateOfBirth(new Date());
        demo.setGender("Female");
        demo.setRace("Black");
        
        CustomerAddress address = new CustomerAddress();
        address.setStreetAddress("21 jump street");
        address.setPostalAddress("8000");
     
     CreditCard creditCard1 = new CreditCard.Builder("98765412308")
                .balance(new BigDecimal(3000.00))
                .expiryDate(new Date())
                .nameOnCreditCard("Messi10")
                .build();
        
        CreditCard creditCard2 = new CreditCard.Builder("789654123056")
                .balance(new BigDecimal(4000.00))
                .expiryDate(new Date())
                .nameOnCreditCard("Neymar11")
                .build();
        
        List<CreditCard> creditCards = new ArrayList<CreditCard>();
        creditCards.add(creditCard1);
        creditCards.add(creditCard2);
        
        Customer customer = new Customer.Builder("100011")
                .customerName(customerName)
                .customerContact(contact)
                .demographic(demo)
                .customerAddress(address)
                .creditCard(creditCards)
                .build();  
        customerRepository.save(customer);
        
        OrderItem item1 = new OrderItem.Builder(1)
                                .build();
          
          OrderItem item2 = new OrderItem.Builder(2)
                                .build();
          
          List<OrderItem> items = new ArrayList<OrderItem>();
          items.add(item1);
          items.add(item2);
                   
        CustomerInvoice invoice = new CustomerInvoice.Builder("20583")
                                        .invoiceDate(new Date())
                                        .orderAmount(new BigDecimal(5000.00))
                                        .invoiceStatus("Not Paid")
                                        .build();
          
        Orders order = new Orders.Builder(425)
                .customer(customer)
                .orderDate(new Date())
                .item(items)
                .customerInvoice(invoice)
                .build();
   
        orderRepository.save(order);
      
        id = order.getId();
       
        Assert.assertNotNull(order);

    }

    @Test(dependsOnMethods = "createOrder", enabled = true)
    public void readOrder() {
        orderRepository = ctx.getBean(OrderRepository.class);
        
       Orders order = orderRepository.findOne(id);
        Assert.assertEquals(order.getOrderNumber(), 425);

    }

    @Test(dependsOnMethods = "readOrder", enabled = false)
    private void updateOrder() {
       orderRepository = ctx.getBean(OrderRepository.class);
        
       Orders order = orderRepository.findOne(id);
       
       Orders updateOrder = new Orders.Builder(425)
               .order(order)
               .orderDate(new Date())
               .build();

        orderRepository.save(updateOrder);
        Orders newOrder= orderRepository.findOne(id);
        Assert.assertEquals(newOrder.getOrderDate(), new Date());

    }

    @Test(dependsOnMethods = "updateOrder", enabled = false)
    private void deleteOrder() {

       orderRepository = ctx.getBean(OrderRepository.class);
       
       Orders order = orderRepository.findOne(id);
       
        orderRepository.delete(order);
       
        Orders deletedOrder = orderRepository.findOne(id);
  
        Assert.assertNull(deletedOrder);

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
