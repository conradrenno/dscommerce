package com.devrenno.dscommerce.services;

import com.devrenno.dscommerce.dto.CategoryDTO;
import com.devrenno.dscommerce.entities.Category;
import com.devrenno.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;



    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> categories = repository.findAll();
        return categories.stream().map(x -> new CategoryDTO(x)).toList();
    }


}
