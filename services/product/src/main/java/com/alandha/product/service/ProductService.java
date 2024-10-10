package com.alandha.product.service;

import com.alandha.product.exception.ProductPurchaseException;
import com.alandha.product.requestAndresponse.ProductPurchaseRequest;
import com.alandha.product.requestAndresponse.ProductPurchaseResponse;
import com.alandha.product.requestAndresponse.ProductRequest;
import com.alandha.product.requestAndresponse.ProductResponse;

import java.util.List;

public interface ProductService {
    Integer createProduct(ProductRequest request);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) throws ProductPurchaseException;

    ProductResponse findById(Integer productId);

    List<ProductResponse> findAll();
}
