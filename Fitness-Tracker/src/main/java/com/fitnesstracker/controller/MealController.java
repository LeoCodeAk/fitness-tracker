package com.fitnesstracker.controller;


import com.fitnesstracker.models.Meal;
import com.fitnesstracker.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/meals")
public class MealController {
    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/add")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        Meal addMeal = mealService.saveMeal(meal);
        return new ResponseEntity<>(addMeal, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Meal>> getMealById(@Param("id")Long userId) {
        List<Meal> getMeals = mealService.getMealByUserId(userId);
        return new ResponseEntity<>(getMeals, HttpStatus.OK);
    }

    @GetMapping("/totalCalories/{userId}")
    public ResponseEntity<Map<String, Integer>> getTotalCaloriesForTheDay(@PathVariable Long userId) {
        Integer totalCalories = mealService.getTotalCaloriesForToday(userId);
        totalCalories = (totalCalories != null) ? totalCalories : 0;
        return new ResponseEntity<>(Map.of("totalCalories",totalCalories), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.noContent().build();
    }

}
