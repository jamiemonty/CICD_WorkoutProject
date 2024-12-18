package ie.atu.workoutserviceapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;

    @PostMapping
    public Workout logWorkout(@RequestBody Workout workout){
        return workoutRepository.save(workout);
    }

    @GetMapping("/user/{userId}")
    public List<Workout> getWorkoutsForUser(@PathVariable Long userId){
        return workoutRepository.findByUserID(userId);
    }
}
