package model;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Routine represents a workout routine which includes muscle groups
public class Routine implements Writable {
    private String name;
    private List<Workout> muscleGroups;

    // EFFECTS: constructs a routine with a name and an empty list of workouts
    public Routine(String name) {
        this.name = name;
        this.muscleGroups = new ArrayList<>();

    }

    // EFFECTS: returns the name of workout
    public String getName() {
        return name;
    }

    // EFFECTS: returns the muscle groups of the routine
    public List<Workout> getMuscleGroups() {
        return muscleGroups;
    }

    // EFFECTS: Assigns the given muscle groups to the muscle groups in the routine
    public void setMuscleGroups(List<Workout> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    // EFFECTS: Adds a workout to the routine
    public void addToRoutine(Workout w) {
        muscleGroups.add(w);
    }

    @Override
    // EFFECTS: returns Workouts represented by this Routine as a JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Routine", workoutsToJson());
        return json;
    }

    // EFFECTS: returns this Routine as a JSON array
    private JSONArray workoutsToJson() {
        JSONArray workouts = new JSONArray();

        for (Workout w : muscleGroups) {
            workouts.put(w.toJson());
        }

        return workouts;
    }

}
