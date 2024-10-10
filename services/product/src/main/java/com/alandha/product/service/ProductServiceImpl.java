package com.alandha.product.service;

import com.alandha.product.exception.ProductPurchaseException;
import com.alandha.product.mapper.ProductMapper;
import com.alandha.product.requestAndresponse.ProductPurchaseRequest;
import com.alandha.product.requestAndresponse.ProductPurchaseResponse;
import com.alandha.product.requestAndresponse.ProductRequest;
import com.alandha.product.requestAndresponse.ProductResponse;
import com.alandha.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;
    private final ProductMapper mapper;

    @Override
    public Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        return repo.save(product).getId();
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) throws ProductPurchaseException {
        var productId = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        var storedProducts = repo.findAllByIdInOrderById(productId);
        if(productId.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products doesn't exist");
        }
        var storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for(int i = 0; i < storedRequest.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);
            if(product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repo.save(product);
            purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

    @Override
    public ProductResponse findById(Integer productId) {
        return repo.findById(productId)
                .map(mapper::toProductResponse)
                .orElseThrow(()->new EntityNotFoundException("Product not found with ID: " + productId));
    }

    @Override
    public List<ProductResponse> findAll() {
        return repo.findAll()
                .stream().map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
