package model;

import java.util.ArrayList;
import java.util.List;


// Represents a workout session which includes muscle groups
public class Session {

    private List<Exercise> sessionTracker;

    //EFFECTS: creates an empty list of muscle groups
    public Session() {
        sessionTracker = new ArrayList<>();

    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to the current session
    public void addExerciseToSession(Exercise e) {
        sessionTracker.add(e);
    }

    // REQUIRES: exercise passed in as input should be in the session
    // MODIFIES: this
    // EFFECTS: Removes the given exercise from the session
    public void removeExerciseFromSession(Exercise e) {
        sessionTracker.remove(e);

    }

    // REQUIRES: given string as input must be an exercise name in the session
    // EFFECTS: returns the exercise with the given string as name and if not found, returns the first item in session
    // since there must be a return type but this case should never happen due to requires clause
    public Exercise searchExercise(String exr) {
        for (Exercise e: sessionTracker) {
            if (e.getName().equals(exr)) {
                return e;
            }
        }
        return sessionTracker.get(0);
    }

    // MODIFIES: this
    // EFFECTS: Returns the next exercise in queue for the session
    public void nextExercise() {
        sessionTracker.remove(0);
    }

    // MODIFIES: this
    // EFFECTS: adds all exercises in the muscle group to the session
    public void addMuscleGroup(Workout mg) {
        int repeat = mg.getSize();
        for (int i = 0; i < repeat; i++) {
            sessionTracker.add(mg.getExerciseAtIndex(i));
        }
    }

    // EFFECTS: Returns the number of exercises currently in the session
    public int getSessionSize() {
        return sessionTracker.size();
    }

    // REQUIRES: r >= 0
    // EFFECTS: Returns Exercise at given index
    public Exercise getExerciseAtIndex(int r) {
        return sessionTracker.get(r);
    }

}
