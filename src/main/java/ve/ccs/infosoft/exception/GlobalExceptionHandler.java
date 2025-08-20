package ve.ccs.infosoft.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import ve.ccs.infosoft.DTO.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	 @ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
	        ErrorResponse error = new ErrorResponse(
	            LocalDateTime.now(),
	            HttpStatus.NOT_FOUND.value(),
	            "Recurso no encontrado",
	            ex.getMessage()
	        );
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	    }

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        List<String> errors = ex.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(error -> error.getField() + ": " + error.getDefaultMessage())
	            .collect(Collectors.toList());

	        ErrorResponse error = new ErrorResponse(
	            LocalDateTime.now(),
	            HttpStatus.BAD_REQUEST.value(),
	            "Error de validación",
	            String.join(", ", errors)
	        );
	        return ResponseEntity.badRequest().body(error);
	    }
	}



