package persistence;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import model.Exercise;
import model.Routine;
import model.Workout;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    Routine testRoutine;

    @Test
    void testWriterInvalidFile() {
        try {
            Routine r = new Routine("Karn's Workout");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail();
        } catch (IOException e) {
            // do nothing
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Routine r = new Routine("Karn's Workout");
            JsonWriter writer = new JsonWriter("./data/emptyWorkouts.json");
            writer.open();
            writer.write(r);
            writer.close();

            JsonReader reader = new JsonReader("./data/emptyWorkouts.json");
            r = reader.read();
            assertEquals("Karn's Workout", r.getName());
            assertEquals(0, r.getMuscleGroups().size());
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            initializeTest();
            JsonWriter writer = new JsonWriter("./data/testRoutine.json");
            writer.open();
            writer.write(testRoutine);
            writer.close();

            JsonReader reader = new JsonReader("./data/testRoutine.json");
            testRoutine = reader.read();
            assertEquals("Karn's Workout", testRoutine.getName());
            List<Workout> w = testRoutine.getMuscleGroups();
            assertEquals(2, w.size());
            checkWorkout("Chest", w.get(0), w.get(0).getSize());
            checkWorkout("Back", w.get(1), w.get(1).getSize());

        } catch (IOException e) {
            fail();
        }
    }

    public void initializeTest() {
        testRoutine = new Routine("Karn's Workout");
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise c1 = new Exercise("Bench Press", 3, 5);
        Exercise c2 = new Exercise("Push-Ups", 3,30);
        Workout b = new Workout("Back");
        Workout c = new Workout("Chest");
        b.addExercise(b1);
        b.addExercise(b2);
        c.addExercise(c1);
        c.addExercise(c2);
        testRoutine.addToRoutine(c);
        testRoutine.addToRoutine(b);
    }
}
