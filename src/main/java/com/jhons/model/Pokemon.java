package com.jhons.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tb_pokemon")
@Data
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private Double weight;
}
