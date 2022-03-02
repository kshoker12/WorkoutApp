package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a set of exercises that form a muscle group
public class Workout implements Writable {

    private List<Exercise> exercises;
    private String name;


    // EFFECTS: creates a new workout with a name and an empty list of exercises
    public Workout(String name) {
        exercises = new ArrayList<>();
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to a muscle group
    public void addExercise(Exercise e) {
        exercises.add(e);
    }

    // REQUIRES: The exercise given as input should already be in muscle group
    // MODIFIES: this
    // EFFECTS: Removes the given exercise from the muscle group
    public void removeExercise(Exercise e) {
        exercises.remove(e);

    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    //REQUIRES: string must be the name of an exercise already in the muscle group
    //EFFECTS: returns an exercise with the same name as given string but returns the first exercise if
    // not found but this case should never occur because of requires clause
    public Exercise findExercise(String i) {
        for (Exercise e : exercises) {
            if (e.getName().equals(i)) {
                return e;
            }
        }
        return exercises.get(0);
    }

    // EFFECTS: gets the number of exercises in a workout
    public int getSize() {
        return exercises.size();
    }

    // EFFECTS: gets the name of the muscle group
    public  String getName() {
        return name;
    }


    // REQUIRES: integer representing index must be >= 0.
    // EFFECTS: Returns the exercise at a given index in muscleGroup
    public Exercise getExerciseAtIndex(int r) {
        return exercises.get(r);
    }

    // EFFECTS: returns the exercises represented by this muscle group
    public List<Exercise> getExercises() {
        return exercises;
    }

    @Override
    // EFFECTS: returns this muscle group as a JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Exercises", exercisesToJson());
        return json;
    }

    // EFFECTS: turns the exercises represented by this muscle group as a JSON array
    private JSONArray exercisesToJson() {
        JSONArray exercises = new JSONArray();

        for (Exercise e : this.exercises) {
            exercises.put(e.toJson());
        }

        return exercises;
    }


}
