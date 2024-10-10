package com.alandha.customer.mapper;

import com.alandha.customer.requestAndresponse.CustomerRequest;
import com.alandha.customer.requestAndresponse.CustomerResponse;
import com.alandha.customer.dto.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {

        if(request == null) {
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .adress(request.adress())
                .build();
    }

    public CustomerResponse formCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAdress()
        );
    }
}
