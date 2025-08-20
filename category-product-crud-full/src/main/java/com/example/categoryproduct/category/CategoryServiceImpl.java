package com.example.categoryproduct.category;

import com.example.categoryproduct.common.dto.PageResponse;
import com.example.categoryproduct.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository repo;

  @Override
  @Transactional(readOnly = true)
  public PageResponse<CategoryDto> getAll(int page, int size) {
    Page<Category> p = repo.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
    return new PageResponse<>(
        p.map(CategoryDto::from).getContent(),
        p.getNumber(), p.getSize(), p.getTotalElements(), p.getTotalPages(),
        p.isFirst(), p.isLast()
    );
  }

  @Override
  public CategoryDto create(CategoryCreateDto req) {
    Category c = Category.builder()
        .name(req.getName())
        .description(req.getDescription())
        .build();
    return CategoryDto.from(repo.save(c));
  }

  @Override
  @Transactional(readOnly = true)
  public CategoryDto getById(Long id) {
    Category c = repo.findById(id).orElseThrow(() -> new NotFoundException("Category " + id + " not found"));
    return CategoryDto.from(c);
  }

  @Override
  public CategoryDto update(Long id, CategoryCreateDto req) {
    Category c = repo.findById(id).orElseThrow(() -> new NotFoundException("Category " + id + " not found"));
    c.setName(req.getName());
    c.setDescription(req.getDescription());
    return CategoryDto.from(repo.save(c));
  }

  @Override
  public void delete(Long id) {
    Category c = repo.findById(id).orElseThrow(() -> new NotFoundException("Category " + id + " not found"));
    repo.delete(c);
  }
}
