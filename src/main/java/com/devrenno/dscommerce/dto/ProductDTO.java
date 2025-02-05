package com.devrenno.dscommerce.dto;

import com.devrenno.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Must be at least 3 characters and max of 80 characters long")
    @NotBlank(message = "Required field")
    private String name;

    @Size(min = 10, message = "Must be at least 10 characters long")
    @NotBlank(message = "Required field")
    private String description;

    @Positive(message = "Price must be positive")
    private Double price;
    private String imgUrl;

    public ProductDTO(){

    }

    public ProductDTO(Long id, String name, Double price, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        description = product.getDescription();
        imgUrl = product.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
