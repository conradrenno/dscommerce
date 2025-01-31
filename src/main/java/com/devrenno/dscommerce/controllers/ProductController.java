package com.devrenno.dscommerce.controllers;

import com.devrenno.dscommerce.dto.ProductDTO;
import com.devrenno.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping(value = "{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findByid(id);
    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO productDTO) {
        return productService.insert(productDTO);
    }
}
