package com.example.product_api.dto;

import com.example.product_api.validation.KhmerName;
import com.example.product_api.validation.LatinName;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ProductRequest {

    @KhmerName
    private String nameKh;

    @LatinName
    private String nameEn;

    @NotNull(message = "price is required and must be numeric")
    private BigDecimal price;

    @NotNull(message = "isActive is required and must be true/false")
    private Boolean isActive;

    @NotNull(message = "createdDate is required and must be in yyyy-MM-dd format")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
}
