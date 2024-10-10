package com.alandha.customer.repository;

import com.alandha.customer.dto.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
