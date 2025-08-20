package com.example.categoryproduct.product;

import com.example.categoryproduct.common.dto.PageResponse;

public interface ProductService {
  PageResponse<ProductDto> getAll(int page, int size);
  ProductDto create(ProductCreateDto req);
  ProductDto getById(Long id);
  ProductDto update(Long id, ProductCreateDto req);
  void delete(Long id);
}
