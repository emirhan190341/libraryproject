package com.emirhanarici.Library.service;

import com.emirhanarici.Library.entity.Category;
import com.emirhanarici.Library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category loadCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }


    public Category findByName(String value) {

        return categoryRepository.findByName(value).orElseThrow(RuntimeException::new);

    }
}
