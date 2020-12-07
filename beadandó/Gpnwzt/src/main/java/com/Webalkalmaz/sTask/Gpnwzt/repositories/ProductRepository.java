package com.Webalkalmaz.sTask.Gpnwzt.repositories;

import org.springframework.stereotype.Repository;

import com.Webalkalmaz.sTask.Gpnwzt.models.Product;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
