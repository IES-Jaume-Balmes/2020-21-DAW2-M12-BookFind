package com.findbook.demo.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

//This is DTO
@Data
public class ItemForm {
    @Min(value = 1)
    private Integer quantity;
    private @NotEmpty Long productId;
}