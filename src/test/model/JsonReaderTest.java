package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class JsonReaderTest extends JsonTest {


    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Routine r = reader.read();
            fail();
        } catch (IOException e) {
            // do nothing
        }
    }

    @Test
    public void testReaderEmptyRoutine() {
        JsonReader reader = new JsonReader("./data/emptyWorkouts.json");
        try {
            Routine r = reader.read();
            assertEquals("Karn's Workout", r.getName());
            assertEquals(0, r.getMuscleGroups().size());
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testReaderMyRoutine() {
        JsonReader reader = new JsonReader("./data/testRoutine.json");
        try {
            Routine r = reader.read();
            assertEquals("Karn's Workout", r.getName());
            List<Workout> w = r.getMuscleGroups();
            assertEquals(2, w.size());
            checkWorkout("Chest", w.get(0), w.get(0).getSize());
            checkWorkout("Back", w.get(1), w.get(1).getSize());
        } catch (IOException e) {
            fail();
        }
    }
}
