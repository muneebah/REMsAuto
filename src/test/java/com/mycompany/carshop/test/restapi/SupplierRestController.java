/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.restapi;

import com.mycompany.carshop.domain.AutoSupplier;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hashcode
 */
public class SupplierRestController {
    private RestTemplate restTemplate;
    
    
    
    
    
    public void testRead(){
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<AutoSupplier[]> responseEntity = restTemplate.exchange("URL",HttpMethod.GET,requestEntity, AutoSupplier[].class);
        
        AutoSupplier [] suppliers = responseEntity.getBody();
       
        
        
    }
    
    private HttpEntity<?> getHttpEntity(){
         HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
}
