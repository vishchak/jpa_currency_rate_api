package com.gmail.vishchak.denis.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String baseCurrency;

    private String conversionCurrency;

    private double conversionRate;

}
