package com.fitnesstracker.service;

import com.fitnesstracker.models.Workout;
import com.fitnesstracker.repo.WorkoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository= workoutRepository;
    }

    public List<Workout> getWorkoutByUserId(Long userId) {
       return  workoutRepository.findByUserIdEntityName(userId);
    }

    @Transactional
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }


}
