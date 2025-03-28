package com.fitnesstracker.repo.impl;

import com.fitnesstracker.models.FoodItem;
import com.fitnesstracker.repo.FoodItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FoodItemRepositoryImpl implements FoodItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(FoodItem foodItem) {
        entityManager.persist(foodItem);
    }

    public List<FoodItem> findAll() {
        return entityManager.createQuery("SELECT f FROM FoodItem f", FoodItem.class)
                .getResultList();
    }

    public FoodItem findById(Long id) {
        return entityManager.find(FoodItem.class, id);
    }

    public List<FoodItem> findByCaloriesLessThan(int maxCalories) {
        return entityManager.createQuery("SELECT f FROM FoodItem f where f.caloriesPer100g < :maxCalories", FoodItem.class)
                .setParameter("maxCalories", maxCalories)
                .getResultList();
    }

    public List<FoodItem> findCaloriesMoreThanProtein(int maxCalories) {
        return entityManager.createQuery("SELECT f from FoodItem f where f.caloriesPer100g > :maxCalories", FoodItem.class)
                .setParameter("maxCalories", maxCalories)
                .getResultList();
    }
}
