package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Campo requerido")
    private String description;
    @Positive(message = "O preço deve ser positivo")
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
