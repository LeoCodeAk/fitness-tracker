package com.fitnesstracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "food_item")
public class FoodItem {

    @Id
    private Long id;

    private String name;
    private int caloriesPer100g;
    private double proteinPer100g;
    private double carbsPer100g;
    private double fatsPer100g;

    public FoodItem() {

    }

    public FoodItem(Long id, String name, int caloriesPer100g, double proteinPer100g, double carbsPer100g, double fatsPer100g) {
        this.id = id;
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
        this.proteinPer100g = proteinPer100g;
        this.carbsPer100g = carbsPer100g;
        this.fatsPer100g = fatsPer100g;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(int caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public double getProteinPer100g() {
        return proteinPer100g;
    }

    public void setProteinPer100g(double proteinPer100g) {
        this.proteinPer100g = proteinPer100g;
    }

    public double getCarbsPer100g() {
        return carbsPer100g;
    }

    public void setCarbsPer100g(double carbsPer100g) {
        this.carbsPer100g = carbsPer100g;
    }

    public double getFatsPer100g() {
        return fatsPer100g;
    }

    public void setFatsPer100g(double fatsPer100g) {
        this.fatsPer100g = fatsPer100g;
    }
}
