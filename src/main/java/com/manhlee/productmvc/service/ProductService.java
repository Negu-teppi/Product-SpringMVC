package com.manhlee.productmvc.service;

import com.manhlee.productmvc.entities.ProductEntity;
import com.manhlee.productmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public void save(ProductEntity product){
        productRepository.save(product);
    }

    public List<ProductEntity> getProductsSortCreateDate(){
        return productRepository.findAllByOrderByCreateDateDesc();
    }

    public ProductEntity getProduct(int id){
        Optional<ProductEntity> optional = productRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
