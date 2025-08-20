package com.example.categoryproduct.product;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductCreateDto {
  @NotBlank private String name;
  private String description;
  @NotNull @DecimalMin("0.0") private BigDecimal price;
  @NotNull private Long categoryId;
}
