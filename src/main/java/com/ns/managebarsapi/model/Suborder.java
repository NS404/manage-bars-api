package com.ns.managebarsapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(SuborderId.class)
public class Suborder {

    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    private int no;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private int subtotal;





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suborder suborder = (Suborder) o;
        return Objects.equals(product, suborder.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}

