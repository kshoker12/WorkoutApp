package model;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private List<Exercise> sessionTracker;

    public Session() {
        sessionTracker = new ArrayList<>();

    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to the current session
    public void addExerciseToSession(Exercise e) {
        sessionTracker.add(e);
    }

    // MODIFIES: this
    // EFFECTS: Removes the given exercise from the session
    public void removeExerciseFromSession(Exercise e) {
        sessionTracker.remove(e);

    }

    // REQUIRES: given string as input must be an exercise in the session
    // EFFECTS: returns the exercise with the given string as name
    public Exercise searchExercise(String exr) {
        Exercise falseExercise;
        for (Exercise e: sessionTracker) {
            if (e.getName() == exr) {
                return e;
            }
        }
        falseExercise = new Exercise("X", 1, 1);
        return falseExercise;
    }

    // MODIFIES: this
    // EFFECTS: Returns the next exercise in queue for the session
    public Exercise nextExercise() {
        sessionTracker.remove(0);
        return sessionTracker.get(0);
    }

    // MODIFIES: this
    // EFFECTS: adds an entire muscle group to the session
    public void addMuscleGroup(Workout mg) {
        int repeat = mg.getSize();
        for (int i = 0; i < repeat; i++) {
            sessionTracker.add(mg.getExerciseAtIndex(0));
            mg.removeExercise(mg.getExerciseAtIndex(0));
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
