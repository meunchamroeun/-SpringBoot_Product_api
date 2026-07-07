package com.example.product_api.dto;

import com.example.product_api.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String nameKh;
    private String nameEn;
    private BigDecimal price;
    private Boolean isActive;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    public static ProductResponse fromEntity(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getNameKh(),
                product.getNameEn(),
                product.getPrice(),
                product.getIsActive(),
                product.getCreatedDate()
        );
    }
}
