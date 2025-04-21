package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vegetable", schema = "fsweb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    private boolean isGrownOnTree;
}
