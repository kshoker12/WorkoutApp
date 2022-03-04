package model;

import model.Exercise;
import model.Workout;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Represents a class which supports the testing of JsonWriterTest and JsonReaderTest
public class JsonTest {

    protected void checkWorkout(String name, Workout w, int size) {
        assertEquals(w.getName(), name);
        assertEquals(w.getExercises().size(), size);
        for (Exercise e: w.getExercises()) {
            checkExercise(e, w.getExercises().indexOf(e), w);
        }
    }

    private void checkExercise(Exercise e, int i, Workout w) {
        if (w.getName() == "Chest") {
            if (i == 0) {
                assertEquals("Bench Press", e.getName());
                assertEquals(3, e.getSets());
                assertEquals(5, e.getReps());
            } else if (i == 1) {
                assertEquals("Push-Ups", e.getName());
                assertEquals(30, e.getReps());
                assertEquals(3, e.getSets());
            }
        } else if (w.getName() == "Back") {
            if (i == 0) {
                assertEquals("Wide-grip Pull-ups", e.getName());
                assertEquals(3, e.getSets());
                assertEquals(10, e.getReps());
            } else if (i == 1) {
                assertEquals("Barbell Rows", e.getName());
                assertEquals(15, e.getReps());
                assertEquals(3, e.getSets());
            }
        }
    }


}
