package persistence;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import model.Exercise;
import model.Routine;
import model.Workout;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Routine read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkout(jsonObject);
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Routine parseWorkout(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Routine r = new Routine(name);
        addWorkouts(r, jsonObject);
        return r;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addWorkouts(Routine r, JSONObject jsonObject) {
        JSONArray workouts = jsonObject.getJSONArray("Routine");
        for (Object w : workouts) {
            JSONObject nextWorkout = (JSONObject) w;
            Workout wr = addWorkout(r, nextWorkout);
            r.addToRoutine(wr);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private Workout addWorkout(Routine wr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        JSONArray exercises = jsonObject.getJSONArray("Exercises");
        Workout workout = new Workout(name);
        for (Object e: exercises) {
            JSONObject nextExercise = (JSONObject) e;
            Exercise s = readExercise(nextExercise);
            workout.getExercises().add(s);
        }
        return workout;
    }

    private Exercise readExercise(JSONObject e) {
        String name = e.getString("name");
        int reps = e.getInt("reps");
        int sets = e.getInt("sets");
        return new Exercise(name, sets, reps);
    }



    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


}
