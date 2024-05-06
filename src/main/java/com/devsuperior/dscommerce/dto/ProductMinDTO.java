package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import org.springframework.beans.BeanUtils;

public class ProductMinDTO {
    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    public ProductMinDTO() {
    }

    public ProductMinDTO(String imgUrl, Double price, String name, Long id) {
        this.imgUrl = imgUrl;
        this.price = price;
        this.name = name;
        this.id = id;
    }
    
    public ProductMinDTO(Product entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
