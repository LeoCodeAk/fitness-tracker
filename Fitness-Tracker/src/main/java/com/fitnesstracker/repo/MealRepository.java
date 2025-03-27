package com.fitnesstracker.repo;

import com.fitnesstracker.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUserId(Long userId);

    //From Entity
    @Query("SELECT m FROM Meal m where m.user_id = :userId")
    List<Meal> findByUserIdSQL(@Param("userId")Long userId);

    //From Table (Native)
    @Query(value = "Select * from meals where user_id = :userId", nativeQuery = true)
    List<Meal> findMealsByUserIdNative(@Param("userId")Long userId);

    //Manual SQL query: Get total calories for a user in a given day
    @Query(value = "SELECT SUM(m.calories) FROM meals m where m.user_id = :userId and DATE(m.dateTime) = CURRENT_DATE ", nativeQuery = true)
    Integer getTotalCaloriesForToday(@Param ("user_id") Long userId);
}
