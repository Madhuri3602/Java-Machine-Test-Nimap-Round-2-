package com.example.categoryproduct.category;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CategoryCreateDto {
  @NotBlank
  private String name;
  private String description;
}
