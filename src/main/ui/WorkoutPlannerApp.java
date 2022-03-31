package ui;

import model.Exercise;
import model.Routine;
import model.Session;
import model.Workout;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//App that can be used to create, edit, and remove workouts from various muscle groups and also add exercises to
// a training session which can be used to track current workout session
public class WorkoutPlannerApp {
    private static final String JSON_STORE = "./data/workouts.json";

    private Session sessionTracker;
    private Boolean active;
    private List<Workout> muscleGroups;
    private Scanner input;
    private Routine routine;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: creates a workout planner app which creates an empty list of muscle groups,
    // creates a routine and initiates the console display.
    // also creates a Json writer and reader object
    public WorkoutPlannerApp() {
        muscleGroups = new ArrayList<>();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        routine = new Routine("Karn's Workout");
        routine.setMuscleGroups(muscleGroups);

        initMuscleGroups();
        printWelcomeMessage();
        setup();
    }

    // EFFECTS: prints out the welcome message to the console
    private void printWelcomeMessage() {
        System.out.println("Welcome, thank you for choosing Workout Planner!");
        System.out.println("Choose one of the following four options...");
    }

    // EFFECTS: prints out the main menu
    private void printMenu() {
        System.out.println("");
        System.out.println("A -> Muscle Groups/Create + edit Exercise");
        System.out.println("B -> add/remove exercise from session");
        System.out.println("C -> view current training session");
        System.out.println("D -> Begin session");
        System.out.println("E -> Load data");
        System.out.println("F -> Save Data");
        System.out.println("Q -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: Handles the inputs the user gives
    private void setup() {
        sessionTracker = new Session();
        active = true;
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        String control = null;


        while (active) {
            printMenu();
            control = input.next();
            control.toLowerCase();
            navigateUser(control);
        }
    }

    // EFFECTS: prints out the next exercise in routine
    private void handleSession(String control) {
        System.out.println("Great selection! Start working Champ!");
        System.out.println("N -> First exercise");
        printNextExercise(control);
        finishSession(control);
    }

    //EFFECTS: prints next exercise in the session once completed
    private void printNextExercise(String control) {
        while (sessionTracker.getSessionSize() > 0) {
            control = input.next();
            control.toLowerCase();
            System.out.println("N -> next exercise");
            if (control.equals("N")) {
                printExercise(sessionTracker.getExerciseAtIndex(0));
                if (sessionTracker.getSessionSize() > 0) {
                    sessionTracker.nextExercise();
                }
            }
        }
    }

    // EFFECTS: Updates the routine
    private void updateRoutine(List<Workout> routine) {
        muscleGroups = routine;
    }

    //EFFECTS: finish exercise session
    private void finishSession(String control) {
        control = input.next();
        control.toLowerCase();
        if (control.equals("N")) {
            System.out.println("Great work champ! See you soon");
            active = false;
        }
    }

    // MODIFIES: this
    // EFFECTS: Carries out the chosen action which user has directed by calling the appropriate methods
    private void navigateUser(String control) {
        switch (control) {
            case "A":
                printMuscleGroups(control);
                break;
            case "B":
                addOrRemoveMenu(control);
                break;
            case "C":
                printSession(control);
                break;
            case "D":
                handleSession(control);
                break;
            case "E":
                loadWorkOut();
                break;
            case "F":
                saveWorkout();
                break;
            case "Q":
                active = false;
                break;
        }
    }

    // EFFECTS: prints out an exercise with its sets and reps
    private void printExercise(Exercise first) {
        System.out.println(first.getName() + " : " + first.getSets() + " Sets : " + first.getReps() + " Reps");
    }

    //EFFECTS: prints out session menu
    private void printSessionMenu() {
        System.out.println("Plan your workout routine by either...");
        System.out.println("A -> Add an entire muscle group");
        System.out.println("B -> Add a single exercise");
        System.out.println("C -> Remove a single exercise");
        System.out.println("Z -> Go back");
    }

    // MODIFIES: this
    // EFFECTS: Menu where you can choose to edit, remove, or add workouts to the muscle groups
    private void addOrRemoveMenu(String control) {
        printSessionMenu();
        control = input.next();
        control.toLowerCase();
        switch (control) {
            case "A":
                addMuscleGroup(control);
                break;
            case "B":
                addToSession(control);
                break;
            case "C":
                removeFromSession(control);
                break;
            case "Z":
                navigateUser(control);
                break;
        }

    }

    //EFFECTS: prints out the muscle group menu
    private void printMuscleGroupMenu() {
        System.out.println("A -> Chest");
        System.out.println("B -> Back");
        System.out.println("C -> Tricep");
        System.out.println("D -> Bicep");
        System.out.println("E -> Shoulder");
        System.out.println("F -> Legs");
        System.out.println("G -> Abs");
        System.out.println("Z -> Go Back");
    }


    // MODIFIES: this
    // EFFECTS: Adds a selected exercise to the current session
    private void addToSession(String control) {
        System.out.println("Choose one of the options below to select from");
        printMuscleGroupMenu();
        control = input.next();
        control.toLowerCase();
        selectCategory(control);
        addOrRemoveMenu(control);

    }

    //EFFECTS: Processes user input and applies printExerciseSession function
    //with the correct argument based on user input
    private void selectCategory(String control) {
        if (control.equals("A")) {
            addExerciseSession(muscleGroups.get(0), control);
        } else if (control.equals("B")) {
            addExerciseSession(muscleGroups.get(1), control);
        } else if (control.equals("C")) {
            addExerciseSession(muscleGroups.get(2), control);
        } else if (control.equals("D")) {
            addExerciseSession(muscleGroups.get(3), control);
        } else if (control.equals("E")) {
            addExerciseSession(muscleGroups.get(4), control);
        } else if (control.equals("F")) {
            addExerciseSession(muscleGroups.get(5), control);
        } else if (control.equals("G")) {
            addExerciseSession(muscleGroups.get(6), control);
        } else {
            navigateUser(control);
        }
    }

    // REQUIRES: any input as an exercise name must exist in one of the muscle groups
    // MODIFIES: this
    // EFFECTS: Prints out all the exercises in muscle group which the user can choose
    // from to add to session
    private void addExerciseSession(Workout muscleGroup, String control) {
        int repeat = muscleGroup.getSize();
        System.out.println("Type out the exercise name you wish to add");
        System.out.println(muscleGroup.getName());
        printExercises(muscleGroup, repeat);
        control = input.next();
        Exercise add = muscleGroup.findExercise(control);
        sessionTracker.addExerciseToSession(add);
    }

    //MODIFIES: this
    //EFFECTS: removes selected exercise from current session
    private void removeFromSession(String control) {
        System.out.println("Select an exercise you wish to remove");
        control = input.next();
        Exercise remove;
        remove = sessionTracker.searchExercise(control);
        sessionTracker.removeExerciseFromSession(remove);
        addOrRemoveMenu(control);
    }

    // MODIFIES: this
    // EFFECTS: Adds an entire muscle group to the session
    private void addMuscleGroup(String control) {
        System.out.println("Choose one of the options below to add to the session");
        printMuscleGroupMenu();
        control = input.next();
        control.toLowerCase();
        String muscle = mapLetterToMuscle(control);
        for (Workout mg : muscleGroups) {
            if (muscle.equals(mg.getName())) {
                sessionTracker.addMuscleGroup(mg);
            }
        }
        addOrRemoveMenu(control);
    }

    //EFFECTS: returns the muscle group corresponding to a given letter in menu
    private String mapLetterToMuscle(String control) {
        switch (control) {
            case "A":
                return "Chest";
            case "B":
                return "Back";
            case "C":
                return "Tricep";
            case "D":
                return "Bicep";
            case "E":
                return "Shoulder";
            case "F":
                return "Legs";
            case "G":
                return "Abs";
        }
        return "Invalid input";
    }

    //EFFECTS: Prints out the muscle groups
    private void printMuscleGroups(String control) {
        System.out.println("Choose one of the options below");
        printMuscleGroupMenu();
        control = input.next();
        control.toLowerCase();
        viewMuscleGroup(control);
    }


    // EFFECTS: Choose which muscle group to view
    @SuppressWarnings("methodlength")
    private void viewMuscleGroup(String control) {
        switch (control) {
            case "A":
                operateExercise(muscleGroups.get(0), control);
                break;
            case "B":
                operateExercise(muscleGroups.get(1), control);
                break;
            case "C":
                operateExercise(muscleGroups.get(2), control);
                break;
            case "D":
                operateExercise(muscleGroups.get(3), control);
                break;
            case "E":
                operateExercise(muscleGroups.get(4), control);
                break;
            case "F":
                operateExercise(muscleGroups.get(5), control);
                break;
            case "G":
                operateExercise(muscleGroups.get(6), control);
                break;
            default:
                navigateUser(control);
                break;
        }
    }

    //EFFECTS: prints out exercise menu
    private void printExerciseMenu() {
        System.out.println("R -> Remove exercise");
        System.out.println("A -> Add exercise");
        System.out.println("E -> Edit existing exercise");
        System.out.println("Z -> Go back");
    }
    
    // MODIFIES: this
    // EFFECTS: carries out various functions on a muscle group such as adding, removing, editing a muscle group
    private void operateExercise(Workout muscleGroup, String control) {
        int repeat = muscleGroup.getSize();
        System.out.println(muscleGroup.getName());
        printExercises(muscleGroup, repeat);
        printExerciseMenu();
        control = input.next();
        control.toLowerCase();
        if (control.equals("R")) {
            muscleGroup.removeExercise(getRidExercise(muscleGroup, control));
            operateExercise(muscleGroup, control);
        } else if (control.equals("A")) {
            muscleGroup.addExercise(addExerciseMuscleGroup(control));
            operateExercise(muscleGroup,control);
        } else if (control.equals("E")) {
            editExercise(muscleGroup, control);
        } else {
            printMuscleGroups(control);
        }
    }

    //Effects: prints out every exercise in muscle group
    private void printExercises(Workout muscleGroup, int repeat) {
        for (int i = 0; i < repeat; i++) {
            printExercise(muscleGroup.getExerciseAtIndex(i));
        }
    }


    // MODIFIES: this
        // EFFECTS: Edits a chosen exercise in given muscle group by modifying its reps and sets
    private void editExercise(Workout muscle,String control) {
        System.out.println("Type name of exercise you want to edit");
        control = input.next();
        Exercise edit = muscle.findExercise(control);
        System.out.println("Type new number of sets");
        int sets = input.nextInt();
        edit.setSets(sets);
        System.out.println("Type new number of reps");
        int reps = input.nextInt();
        edit.setReps(reps);
        operateExercise(muscle, control);
    }


    // MODIFIES: this
    // EFFECTS: create and adds an exercise to muscle group
    public Exercise addExerciseMuscleGroup(String control) {
        System.out.println("Type name of the exercise");
        control = input.next();
        String name = control;
        System.out.println("Type number of sets");
        int sets = input.nextInt();
        System.out.println("Type number of reps");
        int reps = input.nextInt();
        return new Exercise(name, sets, reps);
    }

    // MODIFIES: this
    // EFFECTS: removes an exercise from the muscle group
    public Exercise getRidExercise(Workout muscleGroup, String control) {
        System.out.println("Type name of the exercise");
        control = input.next();
        int repeat = muscleGroup.getSize();
        for (int i = 0; i < repeat; i++) {
            Exercise e = muscleGroup.getExerciseAtIndex(i);
            if (e.getName().equals(control)) {
                return muscleGroup.getExerciseAtIndex(i);
            }
        }
        return new Exercise("X", 0, 0); //stub value

    }


    // EFFECTS: Prints today's workout into the console
    private void printSession(String control) {
        int repeat = sessionTracker.getSessionSize();
        for (int i = 0; i < repeat; i++) {
            printExercise(sessionTracker.getExerciseAtIndex(i));
        }


    }

    //EFFECTS: instantiates back muscle group
    private Workout initBack() {
        Workout back = new Workout("Back");
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise b3 = new Exercise("Angel & Devil", 3, 30);
        Exercise b4 = new Exercise("Deadlifts", 3, 5);
        back.getExercises().add(b1);
        back.getExercises().add(b2);
        back.getExercises().add(b3);
        back.getExercises().add(b4);
        return back;
    }

    //EFFECTS: instantiates chest muscle group
    private Workout initChest() {
        Workout chest = new Workout("Chest");
        Exercise c1 = new Exercise("Bench Press", 3, 5);
        Exercise c2 = new Exercise("Push-Ups", 3, 30);
        Exercise c3 = new Exercise("Incline Bench Press", 3, 10);
        chest.getExercises().add(c1);
        chest.getExercises().add(c2);
        chest.getExercises().add(c3);
        return chest;
    }

    //EFFECTS: instantiate bicep muscle group
    private Workout initBicep() {
        Workout bicep = new Workout("Bicep");
        Exercise bi1 = new Exercise("Hammer Curl", 3, 12);
        Exercise bi2 = new Exercise("Chin-Ups", 3, 15);
        Exercise bi3 = new Exercise("Barbell Curl", 3, 12);
        bicep.getExercises().add(bi1);
        bicep.getExercises().add(bi2);
        bicep.getExercises().add(bi3);
        return bicep;
    }

    //EFFECTS: instantiates a shoulder muscle group
    private Workout initShoulder() {
        Workout shoulder = new Workout("Shoulder");
        Exercise s1 = new Exercise("Shoulder Press", 3, 12);
        Exercise s2 = new Exercise("Side Raise", 3, 15);
        Exercise s3 = new Exercise("Rear Delt Rows", 3, 12);
        shoulder.getExercises().add(s1);
        shoulder.getExercises().add(s2);
        shoulder.getExercises().add(s3);
        return shoulder;
    }

    //EFFECTS: instantiate a tricep muscle group
    private Workout initTricep() {
        Workout tricep = new Workout("Tricep");
        Exercise t1 = new Exercise("Dips", 3, 15);
        Exercise t2 = new Exercise("Close-grip Push-ups", 3, 20);
        Exercise t3 = new Exercise("Tricep Press", 3, 12);
        tricep.getExercises().add(t1);
        tricep.getExercises().add(t2);
        tricep.getExercises().add(t3);
        return tricep;
    }

    //EFFECTS: instantiates a leg muscle group
    private Workout initLegs() {
        Workout legs = new Workout("Legs");
        Exercise l1 = new Exercise("Leg Press", 3, 10);
        Exercise l2 = new Exercise("Squats", 3, 15);
        Exercise l3 = new Exercise("Calf Raises", 3, 12);
        legs.getExercises().add(l1);
        legs.getExercises().add(l2);
        legs.getExercises().add(l3);
        return legs;
    }

    //EFFECTS: instantiates an abs muscle group
    private Workout initAbs() {
        Workout abs = new Workout("Abs");
        Exercise a1 = new Exercise("Crunches", 3, 30);
        Exercise a2 = new Exercise("Leg Raises", 3, 30);
        Exercise a3 = new Exercise("Rotating Sit-Ups", 3, 30);
        abs.getExercises().add(a1);
        abs.getExercises().add(a2);
        abs.getExercises().add(a3);
        return abs;
    }

    //MODIFIES: this
    //EFFECTS: instantiates the pre-set muscle groups and adds it to muscle groups available
    private void initMuscleGroups() {
        Workout back = initBack();
        Workout chest = initChest();
        Workout bicep = initBicep();
        Workout shoulder = initShoulder();
        Workout tricep = initTricep();
        Workout legs = initLegs();
        Workout abs = initAbs();
        muscleGroups.add(chest);
        muscleGroups.add(back);
        muscleGroups.add(tricep);
        muscleGroups.add(bicep);
        muscleGroups.add(shoulder);
        muscleGroups.add(legs);
        muscleGroups.add(abs);
    }



    // EFFECTS: Saves workout from file
    private void saveWorkout() {
        try {
            jsonWriter.open();
            jsonWriter.write(routine);
            jsonWriter.close();
            System.out.println("Saved " + routine.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorkOut() {
        try {
            routine = jsonReader.read();
            updateRoutine(routine.getMuscleGroups());
            System.out.println("Loaded " + routine.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
