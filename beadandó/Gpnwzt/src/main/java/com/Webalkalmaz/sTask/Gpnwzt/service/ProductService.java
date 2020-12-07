package com.Webalkalmaz.sTask.Gpnwzt.service;

import java.util.List;

import com.Webalkalmaz.sTask.Gpnwzt.models.Product;
import com.Webalkalmaz.sTask.Gpnwzt.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository.findById(id).get();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

}
