/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.domain.CreditCard;
import com.mycompany.carshop.domain.Customer;
import com.mycompany.carshop.domain.CustomerInvoice;
import com.mycompany.carshop.domain.Orders;
import com.mycompany.carshop.repository.CreditCardRepository;
import com.mycompany.carshop.repository.CustomerInvoiceRepository;
import com.mycompany.carshop.repository.OrderRepository;
import com.mycompany.carshop.services.CreditCardService;
import com.mycompany.carshop.services.OrderAmountService;
import com.mycompany.carshop.services.ProcessInvoicesService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class ProcessInvoicesServiceImpl implements ProcessInvoicesService{

    @Autowired
    CustomerInvoiceRepository customerInvoiceService;
    
    @Autowired
    CreditCardRepository creditCardService;
    
    @Autowired
    OrderRepository orderService;
    
    @Autowired
    CreditCardService CreditCardService;
    
    @Autowired
    OrderAmountService orderAmountService;
    
    @Override
    public void processInvoice(Long invoiceID) {

        CustomerInvoice invoice = customerInvoiceService.findOne(invoiceID);
        
        if(invoice.getInvoiceStatus().equals("UNPAID")) {
            List<Orders> orders = orderService.findAll();
            for(Orders order : orders) {
                if(order.getCustomerInvoice().equals(invoice)) {
                    Customer customer = order.getCustomer();
                    List<CreditCard> creditCards = customer.getCreditCard();
                    for(CreditCard creditCard : creditCards) {
                       BigDecimal amount = orderAmountService.calculateOrderAmount(order.getId());
                       String approval = CreditCardService.processPayment(creditCard.getCreditNumber(), amount, creditCard.getExpiryDate());
                       if(approval.equals("APPROVED")) {
                           double bal = creditCard.getBalance().doubleValue();
                           bal -= amount.doubleValue();
                           creditCard.setBalance(new BigDecimal(bal));
                           creditCardService.save(creditCard);
                           invoice.setInvoiceStatus("PAID");
                           customerInvoiceService.save(invoice);
                       }
                    }
                }
            }
        }
    }
    
}
