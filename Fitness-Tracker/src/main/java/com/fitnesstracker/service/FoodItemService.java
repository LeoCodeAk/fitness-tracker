package com.fitnesstracker.service;

import com.fitnesstracker.models.FoodItem;
import com.fitnesstracker.repo.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public void addFoodItem(FoodItem item) {
         foodItemRepository.save(item);
    }
    public List<FoodItem> findAllFoodItem() {
        return foodItemRepository.findAll();
    }

    public FoodItem findFoodItemById(Long id) {
        return foodItemRepository.findById(id);
    }

    public List<FoodItem> findCaloriesLessThanMaxCalories(int maxCalories) {
        if(maxCalories <= 0) {
            throw new IllegalArgumentException("Calories must be greated than Zero");
        }
        List<FoodItem> lowCalorieFoods = foodItemRepository.findByCaloriesLessThan(maxCalories);
        if(lowCalorieFoods.isEmpty()) {
            throw new RuntimeException("No food items found under " + maxCalories + " calories");
        }

        return lowCalorieFoods;
    }

    public List<FoodItem> findCaloriesMoreThanProtein(int maxCalories) {
        if(maxCalories <= 0) {
            throw new IllegalArgumentException("calories cannot be less than 0");
        }
        List<FoodItem> calorieItem = foodItemRepository.findCaloriesMoreThanProtein(maxCalories);
        if(calorieItem.isEmpty()) {
            throw new RuntimeException("The item is empty");
        }
        return calorieItem;
    }

}
