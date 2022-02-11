package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class WorkoutTest {

    private Workout muscleGroup;

    @BeforeEach
    public void workoutConstructor() {
        muscleGroup = new Workout("Back");
    }

    @Test
    public void testConstructor() {
       assertEquals(0, muscleGroup.getSize());
       assertEquals("Back", muscleGroup.getName());
    }

    @Test
    public void testAddExercise() {
        Exercise e1 = new Exercise("Angel and Devil", 3, 30);
        muscleGroup.addExercise(e1);
        assertEquals(1, muscleGroup.getSize());
        assertEquals(e1, muscleGroup.getExerciseAtIndex(0));
        Exercise e2 = new Exercise("Wide-grip Pull-Ups", 3, 10);
        muscleGroup.addExercise(e2);
        assertEquals(2, muscleGroup.getSize());
        assertEquals(e2, muscleGroup.getExerciseAtIndex(1));
    }

    @Test
    public void testRemoveExercise() {
        Exercise e1 = new Exercise("Angel and Devil", 3, 30);
        muscleGroup.addExercise(e1);
        Exercise e2 = new Exercise("Wide-grip Pull-Ups", 3, 10);
        muscleGroup.addExercise(e2);
        assertEquals(2 , muscleGroup.getSize());
        muscleGroup.removeExercise(e1);
        assertEquals(1, muscleGroup.getSize());
        assertEquals(e2, muscleGroup.getExerciseAtIndex(0));
        assertFalse(e1 == muscleGroup.getExerciseAtIndex(0));
        muscleGroup.removeExercise(e2);
        assertEquals(0, muscleGroup.getSize());
    }


}
