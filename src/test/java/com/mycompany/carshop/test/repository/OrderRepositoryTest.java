/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.CustomerInvoice;
import com.mycompany.carshop.domain.Order;
import com.mycompany.carshop.domain.OrderItem;
import com.mycompany.carshop.repository.CustomerInvoiceRepository;
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
    private CustomerInvoiceRepository invoiceRepository;
    private OrderItemRepository itemRepository;
    public OrderRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createOrder() {
       
        orderRepository = ctx.getBean(OrderRepository.class);
        invoiceRepository = ctx.getBean(CustomerInvoiceRepository.class);
        itemRepository = ctx.getBean(OrderItemRepository.class);
        
        CustomerInvoice invoice = new CustomerInvoice.Builder("205820")
                                        .invoiceDate(new Date())
                                        .orderAmount(new BigDecimal(50.00))
                                        .invoiceStatus("UnPaid")
                                        .build();
        
        invoiceRepository.save(invoice);
        //id = invoice.getId();
        //Assert.assertNotNull(invoice); 
        
        OrderItem item1 = new OrderItem.Builder(1)
                                .build();
        
          itemRepository.save(item1);
          
          OrderItem item2 = new OrderItem.Builder(2)
                                .build();
        
          itemRepository.save(item2);
          
          List<OrderItem> items = new ArrayList();
          items.add(item1);
          items.add(item2);
          
        Order order = new Order.Builder(425)
                .orderDate(new Date())
                .customerInvoice(invoice)
                .item(items)
                .build();
   
        orderRepository.save(order);
      
        id = order.getId();
       
        Assert.assertNotNull(order);

    }

    @Test(dependsOnMethods = "createOrder", enabled = true)
    public void readOrder() {
        orderRepository = ctx.getBean(OrderRepository.class);
        
       Order order = orderRepository.findOne(id);
        Assert.assertEquals(order.getOrderDate(), new Date());

    }

    @Test(dependsOnMethods = "readOrder", enabled = true)
    private void updateOrder() {
       orderRepository = ctx.getBean(OrderRepository.class);
        
       Order order = orderRepository.findOne(id);
       
       Order updateOrder = new Order.Builder(425)
               .order(order)
               .orderDate(new Date())
               .build();

        orderRepository.save(updateOrder);
        Order newOrder= orderRepository.findOne(id);
        Assert.assertEquals(newOrder.getOrderDate(), new Date());

    }

    @Test(dependsOnMethods = "updateOrder", enabled = true)
    private void deleteOrder() {

       orderRepository = ctx.getBean(OrderRepository.class);
       
       Order order = orderRepository.findOne(id);
       
        orderRepository.delete(order);
       
        Order deletedOrder = orderRepository.findOne(id);
  
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
