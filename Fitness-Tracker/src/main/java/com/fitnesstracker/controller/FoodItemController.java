package com.fitnesstracker.controller;

import com.fitnesstracker.models.FoodItem;
import com.fitnesstracker.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fooditem/")
public class FoodItemController {

    private FoodItemService foodItemService;

    @Autowired
    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addFoodItem(@RequestBody FoodItem foodItem) {
         foodItemService.addFoodItem(foodItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findAllFood")
    public ResponseEntity<List<FoodItem>> findAllFoodItem(FoodItem item) {
        List<FoodItem> allItems = foodItemService.findAllFoodItem();
        return new ResponseEntity<>(allItems, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FoodItem> findFoodItemById(@PathVariable("id") Long foodId) {
        FoodItem findItem = foodItemService.findFoodItemById(foodId);
        return  new ResponseEntity<>(findItem, HttpStatus.OK);
    }

    @GetMapping("/find/low-calories/{maxCalories}")
    public ResponseEntity<List<FoodItem>> findFoodItemBy100gCalories(@PathVariable int maxCalories) {
        try {
            List<FoodItem> item100gLessThanCalories = foodItemService.findCaloriesLessThanMaxCalories(maxCalories);
            return new ResponseEntity<>(item100gLessThanCalories, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/low-protein/{maxCalories}")
    public ResponseEntity<List<FoodItem>> findFoodItemLessThan100gProtein(@PathVariable int maxCalories) {
        try {
            List<FoodItem> findFoodMoreThan100gProtein = foodItemService.findCaloriesMoreThanProtein(maxCalories);
            return new ResponseEntity<>(findFoodMoreThan100gProtein, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
