package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductDTO() {
    }

    public ProductDTO(String imgUrl, Double price, String description, String name, Long id) {
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public ProductDTO(Product entity) {
        imgUrl = entity.getImgUrl();
        price = entity.getPrice();
        description = entity.getDescription();
        name = entity.getName();
        id = entity.getId();
    }


    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
