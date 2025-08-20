package com.example.categoryproduct.product;

import com.example.categoryproduct.common.dto.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService service;

  @GetMapping
  public PageResponse<ProductDto> getAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
    return service.getAll(page, size);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductDto create(@Valid @RequestBody ProductCreateDto req) {
    return service.create(req);
  }

  @GetMapping("/{id}")
  public ProductDto getById(@PathVariable Long id) {
    return service.getById(id);
  }

  @PutMapping("/{id}")
  public ProductDto update(@PathVariable Long id, @Valid @RequestBody ProductCreateDto req) {
    return service.update(id, req);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
