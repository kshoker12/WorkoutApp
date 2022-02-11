package ui;

import model.Exercise;
import model.Session;
import model.Workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//App that keeps track of workout
public class WorkoutPlannerApp {

    private Session sessionTracker;
    private Boolean active;
    private List<Workout> muscleGroups;
    private Scanner input;

    public WorkoutPlannerApp() {
        muscleGroups = new ArrayList<>();
        initMuscleGroups();
        printWelcomeMessage();
        setup();
    }

    // EFFECTS: prints out the welcome message to the console
    private void printWelcomeMessage() {
        System.out.println("Welcome everyone, thank you for choosing Workout Planner!");
        System.out.println("Choose one of the following four options...");
    }

    // EFFECTS: prints out the menu
    private void printMenu() {
        System.out.println("");
        System.out.println("A -> Muscle Groups/Create + edit Exercise");
        System.out.println("B -> add/remove exercise from session");
        System.out.println("C -> view current training session");
        System.out.println("D -> Begin session");
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

    // EFFECTS: Carries out the action which user has directed
    @SuppressWarnings("methodlength")
    private void navigateUser(String control) {
        if (control.equals("a")) {
            printMuscleGroups(control);
        } else if (control.equals("b")) {
            addOrRemoveMenu(control);
        } else if (control.equals("c")) {
            printSession(control);
        } else if (control.equals("d")) {
            System.out.println("Great selection! Start working Champ!");
            System.out.println("N -> First exercise");
            while (sessionTracker.getSessionSize() > 0) {
                control = input.next();
                control.toLowerCase();
                System.out.println("N -> next exercise");
                if (control.equals("n")) {
                    printFirstExercise(sessionTracker.getExerciseAtIndex(0));
                    if (sessionTracker.getSessionSize() > 0) {
                        sessionTracker.nextExercise();
                    }
                }
            }
            control = input.next();
            control.toLowerCase();
            if (control.equals("n")) {
                System.out.println("Great work champ! See you soon");
                active = false;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: The session started and you can cycle through the session
    private void printFirstExercise(Exercise first) {
        System.out.println(first.getName() + " : " + first.getSets() + " Sets : " + first.getReps() + " Reps");
    }

    // EFFECTS: Menu where you can choose how to add or remove exercise
    private void addOrRemoveMenu(String control) {
        System.out.println("Plan your workout routine by either...");
        System.out.println("A -> Add an entire muscle group");
        System.out.println("B -> Add a single exercise");
        System.out.println("C -> Remove a single exercise");
        System.out.println("Z -> Go back");
        control = input.next();
        control.toLowerCase();
        if (control.equals("a")) {
            addMuscleGroup(control);
        } else if (control.equals("b")) {
            addToSession(control);
        } else if (control.equals("c")) {
            removeFromSession(control);
        } else if (control.equals("z")) {
            navigateUser(control);
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
        if (control.equals("a")) {
            addExerciseSession(muscleGroups.get(0), control);
        } else if (control.equals("b")) {
            addExerciseSession(muscleGroups.get(1), control);
        } else if (control.equals("c")) {
            addExerciseSession(muscleGroups.get(2), control);
        } else if (control.equals("d")) {
            addExerciseSession(muscleGroups.get(3), control);
        } else if (control.equals("e")) {
            addExerciseSession(muscleGroups.get(4), control);
        } else if (control.equals("f")) {
            addExerciseSession(muscleGroups.get(5), control);
        } else if (control.equals("g")) {
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
        for (int i = 0; i < repeat; i++) {
            printFirstExercise(muscleGroup.getExerciseAtIndex(i));
        }
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
        if (control.equals("a")) {
            return "Chest";
        } else if (control.equals("b")) {
            return "Back";
        } else if (control.equals("c")) {
            return "Tricep";
        } else if (control.equals("d")) {
            return "Bicep";
        } else if (control.equals("e")) {
            return "Shoulder";
        } else if (control.equals("f")) {
            return "Legs";
        } else if (control.equals("g")) {
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
            case "a":
                printExercise(muscleGroups.get(0), control);
                break;
            case "b":
                printExercise(muscleGroups.get(1), control);
                break;
            case "c":
                printExercise(muscleGroups.get(2), control);
                break;
            case "d":
                printExercise(muscleGroups.get(3), control);
                break;
            case "e":
                printExercise(muscleGroups.get(4), control);
                break;
            case "f":
                printExercise(muscleGroups.get(5), control);
                break;
            case "g":
                printExercise(muscleGroups.get(6), control);
                break;
            default:
                navigateUser(control);
                break;
        }
    }

    // EFFECTS: prints out exercises in a muscle group and various operators can be applied such as
    // Removing exercises from muscle groups and adding exercises from muscle groups, and also edit the number of sets
    // and reps
    private void printExercise(Workout muscleGroup, String control) {
        int repeat = muscleGroup.getSize();
        System.out.println(muscleGroup.getName());
        for (int i = 0; i < repeat; i++) {
            printFirstExercise(muscleGroup.getExerciseAtIndex(i));
        }
        System.out.println("R -> Remove exercise");
        System.out.println("A -> Add exercise");
        System.out.println("E -> Edit existing exercise");
        System.out.println("Z -> Go back");
        control = input.next();
        control.toLowerCase();
        if (control.equals("r")) {
            muscleGroup.removeExercise(getRidExercise(muscleGroup, control));
            printExercise(muscleGroup, control);
        } else if (control.equals("a")) {
            muscleGroup.addExercise(addExerciseMuscleGroup(control));
            printExercise(muscleGroup,control);
        } else if (control.equals("e")) {
            editExercise(muscleGroup, control);
        } else {
            printMuscleGroups(control);
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
        printExercise(muscle, control);
    }


    // MODIFIES: this
    // EFFECTS: adds an exercise from the muscle group
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

    // REQUIRES: the input for control variable must be a real exercise name
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
            printFirstExercise(sessionTracker.getExerciseAtIndex(i));
        }


    }

    //EFFECTS: instantiates the pre-set muscle groups
    @SuppressWarnings("methodlength")
    private void initMuscleGroups() {
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
        muscleGroups.add(chest);
        muscleGroups.add(back);
        muscleGroups.add(tricep);
        muscleGroups.add(bicep);
        muscleGroups.add(shoulder);
        muscleGroups.add(legs);
        muscleGroups.add(abs);
    }

}
