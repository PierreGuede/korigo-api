package com.korigo.api.shared.resources;

import java.time.LocalDateTime;
import java.util.List;

public record ApiErrorResource(
    int status,
    String error,
    String message,
    List<String> details,
    LocalDateTime timestamp
) {
}
