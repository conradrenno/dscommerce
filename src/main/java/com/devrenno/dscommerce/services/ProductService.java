package com.devrenno.dscommerce.services;

import com.devrenno.dscommerce.dto.ProductDTO;
import com.devrenno.dscommerce.entities.Product;
import com.devrenno.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findByid(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }
}
