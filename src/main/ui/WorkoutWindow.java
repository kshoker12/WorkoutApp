package ui;

import model.Exercise;
import model.Routine;
import model.Session;
import model.Workout;

import javax.swing.*;
import java.awt.*;

//Represents the graphical interface of the app
public class WorkoutWindow extends JFrame {
    private MuscleGroupMenu muscleGroupMenu;
    private SessionMenuPanel sessionMenuPanel;
    private MainMenuPanel mainMenuPanel;
    private Routine routine;
    private EastPanelManager muscleGroupManagerPanel;
    private EndSessionPanel endSessionPanel;
    private CardLayout layoutEast;
    private JPanel panelEast;
    private Session session;
    private File fileMenu;

    // EFFECTS: creates the JFrame, as well as necessary panels
    public WorkoutWindow() {
        super("Workout Planner App");
        routine = new Routine("Karn's Workout");
        session = new Session();
        layoutEast = new CardLayout();
        panelEast = new JPanel(layoutEast);
        initMuscleGroups();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(620, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        initMainEastPanel();
        layoutEast.show(panelEast, "Go Back");
        setLayout(new BorderLayout(10, 10));
        mainMenuPanel = new MainMenuPanel(this, panelEast, layoutEast);
        add(mainMenuPanel, BorderLayout.WEST);
        add(panelEast, BorderLayout.EAST);
        panelEast.setVisible(true);
        initPanels();
    }

    // MODIFIES: this
    // EFFECTS: initializes the main east panel
    private void initMainEastPanel() {
        JPanel blank = new JPanel();
        ImageIcon image = new ImageIcon("./data/cpsc-210-project-pic4.png");
        endSessionPanel = new EndSessionPanel();
        panelEast.add(endSessionPanel, "End Session");
        JLabel label = new JLabel();
        label.setIconTextGap(10);
        label.setIcon(image);
        blank.add(label);
        panelEast.add(blank, "Go Back");
    }

    // EFFECTS: initializes all the panels
    public void initPanels() {
        initStateOne();
        initEastPanel();
        initStateTwo();
        initFileMenu();
    }

    // EFFECTS: initializes the file menu
    public void initFileMenu() {
        fileMenu = new File(this, routine, muscleGroupManagerPanel);
    }

    // EFFECTS: initializes the panel located in the east of JFrame
    private void initEastPanel() {
        muscleGroupManagerPanel = new EastPanelManager(session, routine, panelEast, layoutEast);
    }

    // EFFECTS: initializes the first state of panel
    private void initStateOne() {
        muscleGroupMenu = new MuscleGroupMenu(this, panelEast, layoutEast);
    }

    // EFFECT: initializes the second state of panel
    private void initStateTwo() {
        sessionMenuPanel = new SessionMenuPanel(this, panelEast, layoutEast);
    }

    //Getters
    public MuscleGroupMenu getMuscleGroupMenu() {
        return muscleGroupMenu;
    }

    public EastPanelManager getMuscleGroupManagerPanel() {
        return muscleGroupManagerPanel;
    }

    public Routine getRoutine() {
        return routine;
    }

    // MODIFIES: this
    // EFFECTS: initializes the default muscle groups
    private void initMuscleGroups() {
        Workout back = initBack();
        Workout chest = initChest();
        Workout bicep = initBicep();
        Workout shoulder = initShoulder();
        Workout tricep = initTricep();
        Workout legs = initLegs();
        Workout abs = initAbs();
        routine.getMuscleGroups().add(chest);
        routine.getMuscleGroups().add(back);
        routine.getMuscleGroups().add(tricep);
        routine.getMuscleGroups().add(bicep);
        routine.getMuscleGroups().add(shoulder);
        routine.getMuscleGroups().add(legs);
        routine.getMuscleGroups().add(abs);
    }

    //EFFECTS: instantiates back muscle group
    private Workout initBack() {
        Workout back = new Workout("Back");
        Exercise b1 = new Exercise("Wide-grip Pull-ups", 3, 10);
        Exercise b2 = new Exercise("Barbell Rows", 3, 15);
        Exercise b3 = new Exercise("Angel & Devil", 3, 30);
        Exercise b4 = new Exercise("Deadlifts", 3, 5);
        back.addExercise(b1);
        back.addExercise(b2);
        back.addExercise(b3);
        back.addExercise(b4);
        return back;
    }

    //EFFECTS: instantiates chest muscle group
    private Workout initChest() {
        Workout chest = new Workout("Chest");
        Exercise c1 = new Exercise("Bench Press", 3, 5);
        Exercise c2 = new Exercise("Push-Ups", 3, 30);
        Exercise c3 = new Exercise("Incline Bench Press", 3, 10);
        chest.addExercise(c1);
        chest.addExercise(c2);
        chest.addExercise(c3);
        return chest;
    }

    //EFFECTS: instantiate bicep muscle group
    private Workout initBicep() {
        Workout bicep = new Workout("Bicep");
        Exercise bi1 = new Exercise("Hammer Curl", 3, 12);
        Exercise bi2 = new Exercise("Chin-Ups", 3, 15);
        Exercise bi3 = new Exercise("Barbell Curl", 3, 12);
        bicep.addExercise(bi1);
        bicep.addExercise(bi2);
        bicep.addExercise(bi3);
        return bicep;
    }

    //EFFECTS: instantiates a shoulder muscle group
    private Workout initShoulder() {
        Workout shoulder = new Workout("Shoulder");
        Exercise s1 = new Exercise("Shoulder Press", 3, 12);
        Exercise s2 = new Exercise("Side Raise", 3, 15);
        Exercise s3 = new Exercise("Rear Delt Rows", 3, 12);
        shoulder.addExercise(s1);
        shoulder.addExercise(s2);
        shoulder.addExercise(s3);
        return shoulder;
    }

    //EFFECTS: instantiate a tricep muscle group
    private Workout initTricep() {
        Workout tricep = new Workout("Tricep");
        Exercise t1 = new Exercise("Dips", 3, 15);
        Exercise t2 = new Exercise("Close-grip Push-ups", 3, 20);
        Exercise t3 = new Exercise("Tricep Press", 3, 12);
        tricep.addExercise(t1);
        tricep.addExercise(t2);
        tricep.addExercise(t3);
        return tricep;
    }

    //EFFECTS: instantiates a leg muscle group
    private Workout initLegs() {
        Workout legs = new Workout("Legs");
        Exercise l1 = new Exercise("Leg Press", 3, 10);
        Exercise l2 = new Exercise("Squats", 3, 15);
        Exercise l3 = new Exercise("Calf Raises", 3, 12);
        legs.addExercise(l1);
        legs.addExercise(l2);
        legs.addExercise(l3);
        return legs;
    }

    //EFFECTS: instantiates an abs muscle group
    private Workout initAbs() {
        Workout abs = new Workout("Abs");
        Exercise a1 = new Exercise("Crunches", 3, 30);
        Exercise a2 = new Exercise("Leg Raises", 3, 30);
        Exercise a3 = new Exercise("Rotating Sit-Ups", 3, 30);
        abs.addExercise(a1);
        abs.addExercise(a2);
        abs.addExercise(a3);
        return abs;
    }



}



