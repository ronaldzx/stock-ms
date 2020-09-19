package com.everis.stockms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column
    private Long productId;
    @Column
    private Long wareHouseId;
    @Column
    private Integer quantity;
}
