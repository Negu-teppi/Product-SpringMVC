package com.manhlee.productmvc.service;

import com.manhlee.productmvc.entities.CategoryEntity;
import com.manhlee.productmvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getCategories(){
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    public CategoryEntity findCategoryById(int id) {
        Optional<CategoryEntity> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
