package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionTest {

    private Session testSession;

    @BeforeEach
    public void constructor() {
        testSession = new Session();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testSession.getSessionSize());
    }

    @Test
    public void testAddExercise() {
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        testSession.addExerciseToSession(b1);
        assertEquals(1, testSession.getSessionSize());
        assertEquals(b1, testSession.getExerciseAtIndex(0));
        testSession.addExerciseToSession(b2);
        assertEquals(2, testSession.getSessionSize());
        assertEquals(b2, testSession.getExerciseAtIndex(1));
    }

    @Test
    public void testRemoveExerciseFromSession() {
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        testSession.addExerciseToSession(b1);
        testSession.addExerciseToSession(b2);
        assertEquals(2, testSession.getSessionSize());
        testSession.removeExerciseFromSession(b2);
        assertEquals(1, testSession.getSessionSize());
        testSession.removeExerciseFromSession(b1);
        assertEquals(0, testSession.getSessionSize());
    }

    @Test
    public void testSearchExercise() {
        Workout back = new Workout("Back");
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise b3 = new Exercise("Angel & Devil", 3, 30);
        Exercise b4 = new Exercise("Deadlifts", 3, 5);
        back.addExercise(b1);
        back.addExercise(b2);
        back.addExercise(b3);
        back.addExercise(b4);
        testSession.addMuscleGroup(back);
        assertEquals(b1, testSession.searchExercise("Wide-grip Pull-ups"));
        assertEquals(b4, testSession.searchExercise("Deadlifts"));
    }

    @Test
    public void testNextExercise() {
        Workout back = new Workout("Back");
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise b3 = new Exercise("Angel & Devil", 3, 30);
        Exercise b4 = new Exercise("Deadlifts", 3, 5);
        back.addExercise(b1);
        back.addExercise(b2);
        back.addExercise(b3);
        back.addExercise(b4);
        testSession.addMuscleGroup(back);
        assertEquals(b2, testSession.nextExercise());
        assertEquals(b3, testSession.nextExercise());
    }

    @Test
    public void testAddMuscleGroup() {
        Workout back = new Workout("Back");
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise b3 = new Exercise("Angel & Devil", 3, 30);
        Exercise b4 = new Exercise("Deadlifts", 3, 5);
        back.addExercise(b1);
        back.addExercise(b2);
        back.addExercise(b3);
        back.addExercise(b4);
        Workout chest = new Workout("Chest");
        Exercise c1 = new Exercise("Bench Press", 3, 5);
        Exercise c2 = new Exercise("Push-Ups", 3, 30);
        Exercise c3 = new Exercise("Incline Bench Press", 3, 10);
        chest.addExercise(c1);
        chest.addExercise(c2);
        chest.addExercise(c3);
        testSession.addMuscleGroup(back);
        assertEquals(4, testSession.getSessionSize());
        testSession.addMuscleGroup(chest);
        assertEquals(7, testSession.getSessionSize());
    }
}
