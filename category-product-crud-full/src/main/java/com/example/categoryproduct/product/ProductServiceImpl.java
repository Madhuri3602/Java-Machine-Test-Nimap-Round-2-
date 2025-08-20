package com.example.categoryproduct.product;

import com.example.categoryproduct.category.Category;
import com.example.categoryproduct.category.CategoryRepository;
import com.example.categoryproduct.common.dto.PageResponse;
import com.example.categoryproduct.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepo;
  private final CategoryRepository categoryRepo;

  @Override
  @Transactional(readOnly = true)
  public PageResponse<ProductDto> getAll(int page, int size) {
    Page<Product> p = productRepo.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
    return new PageResponse<>(
        p.map(ProductDto::from).getContent(),
        p.getNumber(), p.getSize(), p.getTotalElements(), p.getTotalPages(),
        p.isFirst(), p.isLast()
    );
  }

  @Override
  public ProductDto create(ProductCreateDto req) {
    Category cat = categoryRepo.findById(req.getCategoryId())
        .orElseThrow(() -> new NotFoundException("Category " + req.getCategoryId() + " not found"));
    Product product = Product.builder()
        .name(req.getName())
        .description(req.getDescription())
        .price(req.getPrice())
        .category(cat)
        .build();
    return ProductDto.from(productRepo.save(product));
  }

  @Override
  @Transactional(readOnly = true)
  public ProductDto getById(Long id) {
    Product p = productRepo.findById(id).orElseThrow(() -> new NotFoundException("Product " + id + " not found"));
    return ProductDto.from(p);
  }

  @Override
  public ProductDto update(Long id, ProductCreateDto req) {
    Product p = productRepo.findById(id).orElseThrow(() -> new NotFoundException("Product " + id + " not found"));
    Category cat = categoryRepo.findById(req.getCategoryId())
        .orElseThrow(() -> new NotFoundException("Category " + req.getCategoryId() + " not found"));
    p.setName(req.getName());
    p.setDescription(req.getDescription());
    p.setPrice(req.getPrice());
    p.setCategory(cat);
    return ProductDto.from(productRepo.save(p));
  }

  @Override
  public void delete(Long id) {
    Product p = productRepo.findById(id).orElseThrow(() -> new NotFoundException("Product " + id + " not found"));
    productRepo.delete(p);
  }
}
