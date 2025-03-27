package com.fitnesstracker.controller;

import com.fitnesstracker.models.Workout;
import com.fitnesstracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/workouts")
@RestController
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/add")
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) {
        Workout work = workoutService.saveWorkout(workout);
        return new ResponseEntity<>(work, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Workout>> getWorkoutByUserId(@PathVariable Long userId) {
        List<Workout> getWorkout = workoutService.getWorkoutByUserId(userId);
        if(getWorkout.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(getWorkout, HttpStatus.OK);
    }
}
