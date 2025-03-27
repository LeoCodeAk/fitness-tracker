package com.fitnesstracker.service;

import com.fitnesstracker.models.Meal;
import com.fitnesstracker.repo.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> getMealByUserId(Long userId) {
        return mealRepository.findMealsByUserIdNative(userId);
    }

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public Integer getTotalCaloriesForToday(Long userId) {
        return mealRepository.getTotalCaloriesForToday(userId);
    }

    public Optional<Meal> getMealById(Long id) {
        return mealRepository.findById(id);
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }

}
