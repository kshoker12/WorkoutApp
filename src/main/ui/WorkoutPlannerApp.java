package ui;

import model.Exercise;
import model.Session;
import model.Workout;

import java.util.List;
import java.util.Scanner;

//App that keeps track of workout
public class WorkoutPlannerApp {

    private Scanner input;
    private Session sessionTracker;
    private Boolean stop;

    public WorkoutPlannerApp() {}


    // EFFECTS: prints out the welcome message to the console
    public void printWelcomeMessage() {}

    // MODIFIES: this
    // EFFECTS: Handles the inputs the user gives
    public void handleUserInput() {}

    // EFFECTS: Carries out the action which user has directed
    public void navigateUser() {}


    // EFFECTS: Prints today's workout into the console
    public void printWorkout() {

    }

    //EFFECTS: instantiates the pre-set muscle groups
    public void init() {
        Workout back = new Workout("Back");
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise b3 = new Exercise("Angel & Devil", 3, 30);
        Exercise b4 = new Exercise("Deadlifts", 3, 5);
        back.addExercise(b1);
        back.addExercise(b2);
        back.addExercise(b3);
        back.addExercise(b4);
        Workout chest = new Workout("Chest");
        Exercise c1 = new Exercise("Bench Press", 3, 5);
        Exercise c2 = new Exercise("Push-Ups", 3, 30);
        Exercise c3 = new Exercise("Incline Bench Press", 3, 10);
        chest.addExercise(c1);
        chest.addExercise(c2);
        chest.addExercise(c3);
        Workout bicep = new Workout("Bicep");
        Exercise bi1 = new Exercise("Hammer Curl", 3, 12);
        Exercise bi2 = new Exercise("Chin-Ups", 3, 15);
        Exercise bi3 = new Exercise("Barbell Curl", 3, 12);
        bicep.addExercise(bi1);
        bicep.addExercise(bi2);
        bicep.addExercise(bi3);
        Workout shoulder = new Workout("Shoulder");
        Exercise s1 = new Exercise("Shoulder Press", 3, 12);
        Exercise s2 = new Exercise("Side Raise", 3, 15);
        Exercise s3 = new Exercise("Rear Delt Rows", 3, 12);
        shoulder.addExercise(s1);
        shoulder.addExercise(s2);
        shoulder.addExercise(s3);
        Workout tricep = new Workout("Tricep");
        Exercise t1 = new Exercise("Dips", 3, 15);
        Exercise t2 = new Exercise("Close-grip Push-ups", 3, 20);
        Exercise t3 = new Exercise("Tricep Press", 3, 12);
        tricep.addExercise(t1);
        tricep.addExercise(t2);
        tricep.addExercise(t3);
        Workout legs = new Workout("Legs");
        Exercise l1 = new Exercise("Leg Press", 3, 10);
        Exercise l2 = new Exercise("Squats", 3, 15);
        Exercise l3 = new Exercise("Calf Raises", 3, 12);
        legs.addExercise(l1);
        legs.addExercise(l2);
        legs.addExercise(l3);
        Workout abs = new Workout("Abs");
        Exercise a1 = new Exercise("Crunches", 3, 30);
        Exercise a2 = new Exercise("Leg Raises", 3, 30);
        Exercise a3 = new Exercise("Rotating Sit-Ups", 3, 30);
        abs.addExercise(a1);
        abs.addExercise(a2);
        abs.addExercise(a3);

    }

}
