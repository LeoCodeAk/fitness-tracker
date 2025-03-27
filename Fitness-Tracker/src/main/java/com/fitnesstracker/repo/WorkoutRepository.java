package com.fitnesstracker.repo;

import com.fitnesstracker.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUserId(Long userId);

    @Query("SELECT w FROM Workout w where w.id =  :id")
    List<Workout> findByUserIdEntityName(@Param("id")Long id);

    @Query(value = "SELECT * from workouts WHERE user_id = :id", nativeQuery = true)
    List<Workout> findByUserIdActualTable(@Param("id") Long id);


}
