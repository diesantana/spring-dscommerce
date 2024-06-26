package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientDTO client;
    private PaymentDTO payment;
    @NotEmpty(message = "Deve haver pelo menos 1 item")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, PaymentDTO payment, OrderStatus status, ClientDTO client, Instant moment) {
        this.id = id;
        this.payment = payment;
        this.status = status;
        this.client = client;
        this.moment = moment;
    }
    
    public OrderDTO(Order entity) {
        id = entity.getId();
        payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
        status = entity.getStatus();
        client = new ClientDTO(entity.getClient());
        moment = entity.getMoment();
        for (OrderItem item: entity.getItems()) {
            items.add(new OrderItemDTO(item));
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }
    
    public Double getTotal() {
        Double sum = 0.0;
        for (OrderItemDTO item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }
}
