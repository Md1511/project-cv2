package com.alandha.customer.service;


import com.alandha.customer.requestAndresponse.CustomerRequest;
import com.alandha.customer.requestAndresponse.CustomerResponse;

import java.util.List;

public interface CustomerService {
    String createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String customerId);

    CustomerResponse findById(String customerId);

    void deleteCustomerById(String customerId);
}
