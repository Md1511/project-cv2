package com.alandha.order.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errores
) {
}
