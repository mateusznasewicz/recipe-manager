package pl.mateusz.recipemanagerbackend.models;

import jakarta.persistence.*;
import pl.mateusz.recipemanagerbackend.enums.MeasurementUnit;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;
}
