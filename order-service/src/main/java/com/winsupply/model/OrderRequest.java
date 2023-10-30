package com.winsupply.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.Data;

@Data
public class OrderRequest {

    @Min(value = 0l, message = "The value must be positive")
    @NotNull(message = "Order amount must not be positive")
    private Double orderAmount;

    @Pattern(regexp = "^[a-zA-Z ]{1,200}+$", message = "Only alphabetic characters and spaces are allowed")
    @NotBlank(message = "Order name must not be blank")
    private String orderName;

    private List<OrderLinesRequest> orderLinesRequestList;

}
