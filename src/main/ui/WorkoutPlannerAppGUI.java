package ui;

import model.*;
import model.Event;

import javax.swing.*;
import java.awt.*;

//Represents the graphical interface of the app
public class WorkoutPlannerAppGUI extends JFrame {
    private final Routine routine;
    private EastPanelManager muscleGroupManagerPanel;
    private final CardLayout layoutEast;
    private final JPanel panelEast;

    // EFFECTS: creates the JFrame, as well as necessary panels
    public WorkoutPlannerAppGUI() {
        super("Workout Planner App");
        routine = new Routine("Karn's Workout");
        layoutEast = new CardLayout();
        panelEast = new JPanel(layoutEast);
        initMuscleGroups();
        setupPanel();
        add(new MainMenuPanel(panelEast, layoutEast), BorderLayout.WEST);
        add(panelEast, BorderLayout.EAST);
        panelEast.setVisible(true);
        initPanels();
    }

    // EFFECTS: sets up the panels configurations
    private void setupPanel() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(620, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout(10, 10));
    }

    @Override
    //EFFECTS: prints out the event logs
    public void dispose() {
        super.dispose();
        for (Event next: EventLog.getInstance()) {
            System.out.println(next.toString() + "\n\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes the main east panel
    private void initMainEastPanel() {
        JPanel blank = new JPanel();
        ImageIcon image = new ImageIcon("./data/cpsc-210-project-pic4.png");
        panelEast.add(new EndSessionPanel(), "End Session");
        JLabel label = new JLabel();
        label.setIconTextGap(10);
        label.setIcon(image);
        blank.add(label);
        panelEast.add(blank, "Go Back");
        layoutEast.show(panelEast, "Go Back");
    }

    // EFFECTS: initializes all the panels
    private void initPanels() {
        initMainEastPanel();
        initStateOne();
        initEastPanel();
        initStateTwo();
        initFileMenu();
    }

    // EFFECTS: initializes the file menu
    private void initFileMenu() {
        this.setJMenuBar(new File(routine, muscleGroupManagerPanel));
    }

    // EFFECTS: initializes the panel located in the east of JFrame
    private void initEastPanel() {
        muscleGroupManagerPanel = new EastPanelManager(new Session(), routine, panelEast, layoutEast);
    }

    // EFFECTS: initializes the first state of panel
    private void initStateOne() {
        new MuscleGroupMenu(this, panelEast, layoutEast);
    }

    // EFFECT: initializes the second state of panel
    private void initStateTwo() {
        new SessionMenuPanel(this, panelEast, layoutEast);
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



//
}



