package br.com.client.companyregistry.adapter.in.web;

import br.com.client.companyregistry.adapter.in.web.dto.ErrorResponse;
import br.com.client.companyregistry.domain.exception.CompanyNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCompanyNotFound(CompanyNotFoundException exception, HttpServletRequest request) {
        log.warn("Handling company not found error: {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(OffsetDateTime.now(), HttpStatus.NOT_FOUND.value(), "Company Not Found", exception.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException exception, HttpServletRequest request) {
        log.warn("Handling validation error: {}", exception.getMessage());
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(OffsetDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validation Error", exception.getMessage(), request.getRequestURI()));
    }
}
