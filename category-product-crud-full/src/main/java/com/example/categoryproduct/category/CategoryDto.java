package com.example.categoryproduct.category;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CategoryDto {
  private Long id;
  private String name;
  private String description;

  public static CategoryDto from(Category c) {
    return CategoryDto.builder()
        .id(c.getId())
        .name(c.getName())
        .description(c.getDescription())
        .build();
  }
}
