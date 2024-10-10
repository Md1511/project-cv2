package com.alandha.customer.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errores
) {
}
