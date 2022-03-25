package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        assertEquals(2, muscleGroup.getSize());
        muscleGroup.removeExercise(e1);
        assertEquals(1, muscleGroup.getSize());
        assertEquals(e2, muscleGroup.getExerciseAtIndex(0));
        assertFalse(e1 == muscleGroup.getExerciseAtIndex(0));
        muscleGroup.removeExercise(e2);
        assertEquals(0, muscleGroup.getSize());
    }

    @Test
    public void testFindExercise() {
        Workout back = new Workout("Back");
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise b3 = new Exercise("Angel & Devil", 3, 30);
        Exercise b4 = new Exercise("Deadlifts", 3, 5);
        Exercise falseExercise = new Exercise("X", 1, 1);
        back.addExercise(b1);
        back.addExercise(b2);
        back.addExercise(b3);
        back.addExercise(b4);
        assertEquals(b1, back.findExercise("Wide-grip Pull-ups"));
        assertEquals(b2, back.findExercise("Barbell Rows"));
        assertEquals(b3, back.findExercise("Angel & Devil"));
        assertEquals(b4, back.findExercise("Deadlifts"));
        assertEquals(null, back.findExercise("lift"));
        assertEquals(null, back.findExercise("Drop"));
    }

    @Test
    public void testSetExercises() {
        List<Exercise> testExercise = new ArrayList<>();
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise b3 = new Exercise("Angel & Devil", 3, 30);
        Exercise b4 = new Exercise("Deadlifts", 3, 5);
        testExercise.add(b1);
        testExercise.add(b2);
        testExercise.add(b3);
        testExercise.add(b4);

        muscleGroup.setExercises(testExercise);
        assertEquals(4, muscleGroup.getSize());
    }
}
