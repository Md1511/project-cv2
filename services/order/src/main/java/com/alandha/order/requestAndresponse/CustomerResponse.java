package com.alandha.order.requestAndresponse;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
