package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;

    public OrderItemDTO(Long productId, Integer quantity, Double price, String name) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        quantity = entity.getQuantity();
        price = entity.getPrice();
        name = entity.getProduct().getName();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    public Double getSubTotal(){
        return price * quantity;
    }
}
