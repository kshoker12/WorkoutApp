package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoutineTest {
    Routine testRoutine;

    @BeforeEach
    public void init() {
        testRoutine = new Routine("My workout");

    }

    @Test
    public void testConstructor() {
        assertEquals("My workout", testRoutine.getName());
        assertEquals(0, testRoutine.getMuscleGroups().size());
    }

    @Test
    public void testSetMuscleGroup() {
        Workout testWorkout = new Workout("Back");
        Exercise testExercise = new Exercise("Test", 3, 15);
        testWorkout.addExercise(testExercise);
        List<Workout> workouts = new ArrayList<>();
        workouts.add(testWorkout);
        testRoutine.setMuscleGroups(workouts);
        assertEquals(workouts, testRoutine.getMuscleGroups());

    }

    @Test
    public void testAddToRoutine() {
        Workout testWorkout = new Workout("Back");
        Exercise testExercise = new Exercise("Test", 3, 15);
        testWorkout.addExercise(testExercise);
        testRoutine.addToRoutine(testWorkout);
        assertEquals(testWorkout, testRoutine.getMuscleGroups().get(0));
    }
}
