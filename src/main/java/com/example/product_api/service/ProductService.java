package com.example.product_api.service;

import com.example.product_api.dto.ProductRequest;
import com.example.product_api.entity.Product;
import com.example.product_api.exception.ProductNotFoundException;
import com.example.product_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(ProductRequest request) {
        Product product = toEntity(request);
        return productRepository.save(product);
    }

    public List<Product> createBatch(List<ProductRequest> requests) {
        List<Product> products = requests.stream().map(this::toEntity).toList();
        return productRepository.saveAll(products);
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product updateById(Long id, ProductRequest request) {
        Product product = findById(id);
        product.setNameKh(request.getNameKh());
        product.setNameEn(request.getNameEn());
        product.setPrice(request.getPrice());
        product.setIsActive(request.getIsActive());
        product.setCreatedDate(request.getCreatedDate());
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }

    private Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setNameKh(request.getNameKh());
        product.setNameEn(request.getNameEn());
        product.setPrice(request.getPrice());
        product.setIsActive(request.getIsActive());
        product.setCreatedDate(request.getCreatedDate());
        return product;
    }
}
