package com.winsupply.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class OrderLinesRequest {
    
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 25, message = "Quantity must not exceed 25")
    @NotBlank
    private int quantity;
    
    @Pattern(regexp = "^[a-zA-Z ]{1,200}+$", message = "Only alphabetic characters and spaces are allowed")
    @NotBlank
    private String itemName;
       
    
}
