package com.example.product_api.controller;

import com.example.product_api.dto.ProductBatchRequest;
import com.example.product_api.dto.ProductRequest;
import com.example.product_api.dto.ProductResponse;
import com.example.product_api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addOne(@Valid @RequestBody ProductRequest request) {
        ProductResponse response = ProductResponse.fromEntity(productService.create(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<ProductResponse>> addMulti(@Valid @RequestBody ProductBatchRequest request) {
        List<ProductResponse> responses = productService.createBatch(request.getProducts()).stream()
                .map(ProductResponse::fromEntity)
                .toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> searchById(@PathVariable Long id) {
        ProductResponse response = ProductResponse.fromEntity(productService.findById(id));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateById(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        ProductResponse response = ProductResponse.fromEntity(productService.updateById(id, request));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
