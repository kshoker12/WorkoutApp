package model;

// Represents an exercise with a name, sets, and reps
public class Exercise {
    private String name;
    private int sets;
    private int reps;

    public Exercise(String name, int sets, int reps) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
    }

    // Requires: sets > 0
    // Modifies: this
    // Effects: Replaces the number of sets with the given number
    // of sets
    public void setSets(int sets) {
        this.sets = sets;
    }

    // Requires: reps > 0
    // Modifies: this
    // Effects: Replaces the number of reps with the given input
    public void setReps(int reps) {
        this.reps = reps;
    }

    // EFFECTS: Returns the number of reps in an exercise
    public int getReps() {
        return reps;
    }

    // EFFECTS: Returns the number of sets in an exercise
    public int getSets() {
        return sets;

    }

    // EFFECTS: returns the name of an exercise
    public String getName() {
        return name;
    }



}

