package com.example.product_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductBatchRequest {

    @NotEmpty(message = "products list must not be empty")
    @Valid
    private List<ProductRequest> products;
}
