package com.example.categoryproduct.category;

import com.example.categoryproduct.common.dto.PageResponse;

public interface CategoryService {
  PageResponse<CategoryDto> getAll(int page, int size);
  CategoryDto create(CategoryCreateDto req);
  CategoryDto getById(Long id);
  CategoryDto update(Long id, CategoryCreateDto req);
  void delete(Long id);
}
