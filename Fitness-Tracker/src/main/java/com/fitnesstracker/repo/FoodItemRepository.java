package com.fitnesstracker.repo;

import com.fitnesstracker.models.FoodItem;

import java.util.List;

public interface FoodItemRepository {

    void save(FoodItem item);
    List<FoodItem> findAll();
    FoodItem findById(Long id);
    List<FoodItem> findByCaloriesLessThan(int maxCalories);




}
