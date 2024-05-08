package com.devsuperior.dscommerce.controllers.handlers;

import com.devsuperior.dscommerce.dto.CustomErrorDTO;
import com.devsuperior.dscommerce.dto.ValidationError;
import com.devsuperior.dscommerce.services.exceptions.DatabaseException;
import com.devsuperior.dscommerce.services.exceptions.ForbiddenException;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDTO> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND; 
        CustomErrorDTO errorDTO = new CustomErrorDTO(
                Instant.now(), status.value(), e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(errorDTO);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomErrorDTO> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomErrorDTO errorDTO = new CustomErrorDTO(
                Instant.now(), status.value(), e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(errorDTO);
    }

    // validação com o Bean Validation 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDTO> MethodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; // especifica o cód de erro que vai ser gerado
        
        // Instancia o ValidationError, passando uma lista de erros com o campo e a msg de erro
        // ValidationError é um DTO para customizar validações do bean validation
        ValidationError errorDTO = new ValidationError(
                Instant.now(), status.value(), "Dados inválidos",request.getRequestURI());
        // percorre a lista de erros do Bean Validation e adiciona a nossa lista de error
        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            errorDTO.addFieldMessage(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(errorDTO);
    }


    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<CustomErrorDTO> forbidden(ForbiddenException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        CustomErrorDTO errorDTO = new CustomErrorDTO(
                Instant.now(), status.value(), e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(errorDTO);
    }
    
}
