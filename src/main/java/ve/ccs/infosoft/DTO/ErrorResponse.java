package ve.ccs.infosoft.DTO;

import java.time.LocalDateTime;

// ErrorResponse.java
public record ErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message
) {}