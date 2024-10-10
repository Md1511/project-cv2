package com.alandha.customer.requestAndresponse;

import com.alandha.customer.dto.Address;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address adress
) {
}
