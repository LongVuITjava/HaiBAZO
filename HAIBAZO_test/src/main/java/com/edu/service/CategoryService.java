package com.edu.service;

import java.util.List;
import java.util.Optional;

import com.edu.model.Category;

public interface CategoryService {

	Optional<Category> getCategoryById(Long categoryId);

	List<Category> getAllCategories();

}
