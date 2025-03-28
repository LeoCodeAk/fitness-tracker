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
}
