package com.example.categoryproduct.product;

import com.example.categoryproduct.category.CategoryDto;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductDto {
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private CategoryDto category;

  public static ProductDto from(Product p) {
    return ProductDto.builder()
        .id(p.getId())
        .name(p.getName())
        .description(p.getDescription())
        .price(p.getPrice())
        .category(p.getCategory() != null ? CategoryDto.from(p.getCategory()) : null)
        .build();
  }
}
