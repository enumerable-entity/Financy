package com.financy.financyapp.models.dto;

import com.financy.financyapp.enums.Type;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CategoryDto {

    @NotBlank(message = "Title of category can't be empty")
    @Size(min = 1, max = 20, message = "Title should be between 1 to 20 symbols long")
    private String title;
    @NotNull(message = "Type of category can't be empty")
    private Type type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
