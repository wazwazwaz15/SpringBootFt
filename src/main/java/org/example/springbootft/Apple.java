package org.example.springbootft;

import jakarta.persistence.*;

import java.math.BigDecimal;




@Entity
@Table(name = "apple")
public class Apple {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id ;

    @Column(length = 10)
    public String color;

    @Column(precision = 6, scale = 2)
    public BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
