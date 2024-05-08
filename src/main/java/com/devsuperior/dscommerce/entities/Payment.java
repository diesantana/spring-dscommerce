package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    
    @OneToOne
    @MapsId
    // peculiaridade da JPA é o uso da annotation @MapsId, no lugar do mappedBy. 
    // Isso é para que seja criado no banco relacional a correspondência de ids entre as duas tabelas
    // para o pedido 1, o id do pagamento dele também será 1, para o pedido 2, o id do pagamento dele também será 2
    private Order order;    

    public Payment() {
    }

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
