package com.ashutosh.EcomProductService.controller.controllerAdvice;

import com.ashutosh.EcomProductService.dto.ErrorResponseDTO;
import com.ashutosh.EcomProductService.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(Exception e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(e.getMessage());
        errorResponseDTO.setStatusCode(404);
        return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
    }

}
