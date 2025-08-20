package com.example.categoryproduct.category;

import com.example.categoryproduct.common.dto.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService service;

  @GetMapping
  public PageResponse<CategoryDto> getAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
    return service.getAll(page, size);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CategoryDto create(@Valid @RequestBody CategoryCreateDto req) {
    return service.create(req);
  }

  @GetMapping("/{id}")
  public CategoryDto getById(@PathVariable Long id) {
    return service.getById(id);
  }

  @PutMapping("/{id}")
  public CategoryDto update(@PathVariable Long id, @Valid @RequestBody CategoryCreateDto req) {
    return service.update(id, req);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
