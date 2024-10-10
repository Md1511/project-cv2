package com.alandha.customer.service;

import com.alandha.customer.requestAndresponse.CustomerRequest;
import com.alandha.customer.requestAndresponse.CustomerResponse;
import com.alandha.customer.dto.Customer;
import com.alandha.customer.exception.CustomerNotFoundException;
import com.alandha.customer.mapper.CustomerMapper;
import com.alandha.customer.repository.CustomerRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository repo;
    private final CustomerMapper mapper;

    @Override
    public String createCustomer(CustomerRequest request) {

        var customer = repo.save(mapper.toCustomer(request));

        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        var customer = repo.findById(request.id())
                .orElseThrow(()-> new CustomerNotFoundException(
                        format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())
                ));
        mergeCustomer(customer, request);
        repo.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return repo.findAll()
                .stream()
                .map(mapper::formCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(String customerId) {
        return repo.findById(customerId).isPresent();
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return repo.findById(customerId)
                .map(mapper::formCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("No customer found with the provided ID:: %s", customerId)
                ));
    }

    @Override
    public void deleteCustomerById(String customerId) {
        repo.deleteById(customerId);
    }


    public void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if(StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if(StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if(request.adress() != null) {
            customer.setAdress(request.adress());
        }

    }
}
