package model;

import java.util.ArrayList;
import java.util.List;

// Represents a set of exercises that form a muscle group
public class Workout {

    private List<Exercise> muscleGroup;
    private String name;


    public Workout(String name) {
        muscleGroup = new ArrayList<>();
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to a muscle group
    public void addExercise(Exercise e) {
        muscleGroup.add(e);
    }

    // REQUIRES: The exercise given as input should already be in muscle group
    // MODIFIES: this
    // EFFECTS: Removes the given exercise from the muscle group
    public void removeExercise(Exercise e) {
        muscleGroup.remove(e);

    }

    //REQUIRES: an exercise name of an exercise inside the given muscle group
    //EFFECTS: returns an exercise with the same name as given string
    public Exercise findExercise(String e) {
        return null;  //stub
    }

    // EFFECTS: gets the number of exercises in a workout
    public int getSize() {
        return muscleGroup.size();
    }

    // EFFECTS: gets the name of the muscle group
    public String getName() {
        return name;
    }


    // REQUIRES: integer representing index must be >= 0.
    // EFFECTS: Returns the exercise at a given index in muscleGroup
    public Exercise getExerciseAtIndex(int r) {
        return muscleGroup.get(r);
    }

    // MODIFIES: this
    // EFFECTS: Sets the current workout to the selected muscle group
    public void selectWorkout() {

    }
}
