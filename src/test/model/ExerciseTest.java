package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {

    private Exercise e;

    @BeforeEach
    public void exerciseConstructor() {
        e = new Exercise("Pull-ups", 3, 10);
    }

    @Test
    public void testConstructor() {
        assertEquals("Pull-ups", e.getName());
        assertEquals(10, e.getReps());
        assertEquals(3, e.getSets());
    }

    @Test
    public void testSetSets() {
        assertEquals(3, e.getSets());
        e.setSets(4);
        assertEquals(4, e.getSets());
        e.setSets(2);
        assertEquals(2, e.getSets());
    }

    @Test
    public void testSetReps() {
        assertEquals(10, e.getReps());
        e.setReps(15);
        assertEquals(15, e.getReps());
        e.setReps(20);
        assertEquals(20, e.getReps());
    }

    @Test
    public void testEditExercise() {
        e.editExercise(4, 5);
        assertEquals(4, e.getSets());
        assertEquals(5, e.getReps());
        e.editExercise(5, 7);
        assertEquals(5, e.getSets());
        assertEquals(7, e.getReps());
    }
}
