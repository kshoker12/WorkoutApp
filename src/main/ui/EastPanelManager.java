package ui;

import model.Exercise;
import model.Routine;
import model.Session;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Manages all the panels which can be displayed on the East of the Workout Window
public class EastPanelManager {
    private final JPanel east;
    private final CardLayout eastLayout;
    private Routine routine;
    private final Session session;

    // EFFECTS: creates all the panels and also creates lists which hold each category of panels
    public EastPanelManager(Session session, Routine routine, JPanel east, CardLayout eastLayout) {
        this.session = session;
        this.east = east;
        this.routine = routine;
        this.eastLayout = eastLayout;
        updateViewSessionPanel();
        updateLiveSessionPanel();
        repaintPanels();
    }

    // MODIFIES: routine
    // EFFECTS: sets the routine to given routine
    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    // EFFECTS: repaints all the panels in east panel
    public void repaintPanels() {
        initChestPanel();
        initBackPanel();
        initTricepPanel();
        initBicepPanel();
        initShouldersPanel();
        initLegsPanel();
        initAbsPanel();
        east.revalidate();
        east.repaint();
    }

    // EFFECTS: initializes the view session panel
    public void updateViewSessionPanel() {
        JPanel viewSessionPanel = new JPanel(new GridLayout(7, 1, 10, 10));
        east.add(viewSessionPanel, "View Session");
        viewSessionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        viewSessionPanel.setBackground(Color.LIGHT_GRAY);
        viewSessionPanel.setPreferredSize(new Dimension(300, 400));
        for (Exercise e: session.getSessionTracker()) {
            JLabel j = new JLabel(e.getName() + " : " + e.getSets() + " Sets : " + e.getReps() + " Reps");
            viewSessionPanel.add(j);
            j.setFont(new Font("Arial", Font.ITALIC, 16));
            j.setPreferredSize(new Dimension(280, 30));
            j.setBackground(Color.lightGray);
        }
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(280,30));
        goBackButton.setFont(new Font("Arial",Font.BOLD, 20));
        viewSessionPanel.add(goBackButton);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Go Back");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for abs
    private void initAbsPanel() {
        WorkoutsPanel absPanel = new
                WorkoutManagerPanel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        east.add(absPanel, "Abs");
        WorkoutsPanel absAddPanel = new
                WorkoutsEditPanel(this, routine.getMuscleGroups().get(6), 0);
        east.add(absAddPanel, "Abs Add");
        WorkoutsPanel absRemovePanel = new
                HandleExercisePanel(this, routine.getMuscleGroups().get(6), 0);
        east.add(absRemovePanel, "Abs Remove");
        WorkoutsPanel absEditPanel =
                new WorkoutsEditPanel(this, routine.getMuscleGroups().get(6), 1);
        east.add(absEditPanel, "Abs Edit");
        WorkoutsPanel absAddSessionPanel =
                new SessionAddPanel(this, routine.getMuscleGroups().get(6), session, east, eastLayout);
        east.add(absAddSessionPanel, "Abs Add Session");
        WorkoutsPanel absSessionAddExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(6), 2);
        east.add(absSessionAddExercise, "Abs Add Exercise");
        WorkoutsPanel absSessionRemoveExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(6), 1);
        east.add(absSessionRemoveExercise, "Abs Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for legs
    private void initLegsPanel() {
        WorkoutsPanel legsPanel = new
                WorkoutManagerPanel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        east.add(legsPanel, "Legs");
        WorkoutsPanel addLegsPanel = new
                WorkoutsEditPanel(this, routine.getMuscleGroups().get(5), 0);
        east.add(addLegsPanel, "Legs Add");
        WorkoutsPanel legsRemovePanel = new
                HandleExercisePanel(this, routine.getMuscleGroups().get(5), 0);
        east.add(legsRemovePanel, "Legs Remove");
        WorkoutsPanel legsEditPanel =
                new WorkoutsEditPanel(this, routine.getMuscleGroups().get(5), 1);
        east.add(legsEditPanel, "Legs Edit");
        WorkoutsPanel legsAddSessionPanel =
                new SessionAddPanel(this, routine.getMuscleGroups().get(5), session, east, eastLayout);
        east.add(legsAddSessionPanel, "Legs Add Session");
        WorkoutsPanel legsSessionAddExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(5), 2);
        east.add(legsSessionAddExercise, "Legs Add Exercise");
        WorkoutsPanel legsSessionRemoveExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(5), 1);
        east.add(legsSessionRemoveExercise, "Legs Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for shoulders
    private void initShouldersPanel() {
        WorkoutsPanel shoulderPanel = new
                WorkoutManagerPanel(this,routine.getMuscleGroups().get(4), east, eastLayout);
        east.add(shoulderPanel, "Shoulders");
        WorkoutsPanel shouldersAddPanel = new
                WorkoutsEditPanel(this, routine.getMuscleGroups().get(4), 0);
        east.add(shouldersAddPanel, "Shoulders Add");
        WorkoutsPanel shouldersRemovePanel = new
                HandleExercisePanel(this, routine.getMuscleGroups().get(4), 0);
        east.add(shouldersRemovePanel, "Shoulders Remove");
        WorkoutsPanel shouldersEditPanel =
                new WorkoutsEditPanel(this, routine.getMuscleGroups().get(4), 1);
        east.add(shouldersEditPanel, "Shoulders Edit");
        WorkoutsPanel shoulderAddSessionPanel =
                new SessionAddPanel(this, routine.getMuscleGroups().get(4), session, east, eastLayout);
        east.add(shoulderAddSessionPanel, "Shoulders Add Session");
        WorkoutsPanel shouldersSessionAddExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(4), 2);
        east.add(shouldersSessionAddExercise, "Shoulders Add Exercise");
        WorkoutsPanel shouldersSessionRemoveExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(4), 1);
        east.add(shouldersSessionRemoveExercise, "Shoulders Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for biceps
    private void initBicepPanel() {
        WorkoutsPanel bicepPanel = new
                WorkoutManagerPanel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        east.add(bicepPanel, "Biceps");
        WorkoutsPanel bicepAddPanel = new
                WorkoutsEditPanel(this, routine.getMuscleGroups().get(3), 0);
        east.add(bicepAddPanel, "Biceps Add");
        WorkoutsPanel bicepRemovePanel = new
                HandleExercisePanel(this, routine.getMuscleGroups().get(3), 0);
        east.add(bicepRemovePanel, "Biceps Remove");
        WorkoutsPanel bicepEditPanel =
                new WorkoutsEditPanel(this, routine.getMuscleGroups().get(3), 1);
        east.add(bicepEditPanel, "Biceps Edit");
        WorkoutsPanel bicepAddSessionPanel =
                new SessionAddPanel(this, routine.getMuscleGroups().get(3), session, east, eastLayout);
        east.add(bicepAddSessionPanel, "Biceps Add Session");
        WorkoutsPanel bicepSessionAddExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(3), 2);
        east.add(bicepSessionAddExercise, "Biceps Add Exercise");
        WorkoutsPanel bicepSessionRemoveExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(3), 1);
        east.add(bicepSessionRemoveExercise, "Biceps Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for triceps
    private void initTricepPanel() {
        WorkoutsPanel tricepPanel = new
                WorkoutManagerPanel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        east.add(tricepPanel, "Triceps");
        WorkoutsPanel tricepAddPanel = new
                WorkoutsEditPanel(this, routine.getMuscleGroups().get(2), 0);
        east.add(tricepAddPanel, "Triceps Add");
        WorkoutsPanel tricepRemovePanel = new
                HandleExercisePanel(this, routine.getMuscleGroups().get(2), 0);
        east.add(tricepRemovePanel, "Triceps Remove");
        WorkoutsPanel tricepsEditPanel =
                new WorkoutsEditPanel(this, routine.getMuscleGroups().get(2), 1);
        east.add(tricepsEditPanel, "Triceps Edit");
        WorkoutsPanel tricepAddSessionPanel =
                new SessionAddPanel(this, routine.getMuscleGroups().get(2), session, east, eastLayout);
        east.add(tricepAddSessionPanel, "Triceps Add Session");
        WorkoutsPanel tricepSessionAddExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(2), 2);
        east.add(tricepSessionAddExercise, "Triceps Add Exercise");
        WorkoutsPanel tricepsSessionRemoveExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(2), 1);
        east.add(tricepsSessionRemoveExercise, "Triceps Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for chest
    private void initChestPanel() {
        WorkoutsPanel chestPanel = new
                WorkoutManagerPanel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        east.add(chestPanel, "Chest");
        WorkoutsPanel chestAddPanel = new
                WorkoutsEditPanel(this, routine.getMuscleGroups().get(0), 0);
        east.add(chestAddPanel, "Chest Add");
        WorkoutsPanel chestRemovePanel = new
                HandleExercisePanel(this, routine.getMuscleGroups().get(0), 0);
        east.add(chestRemovePanel, "Chest Remove");
        WorkoutsPanel chestEditPanel =
                new WorkoutsEditPanel(this, routine.getMuscleGroups().get(0), 1);
        east.add(chestEditPanel, "Chest Edit");
        WorkoutsPanel chestAddSessionPanel =
                new SessionAddPanel(this, routine.getMuscleGroups().get(0), session, east, eastLayout);
        east.add(chestAddSessionPanel, "Chest Add Session");
        WorkoutsPanel chestSessionAddExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(0), 2);
        east.add(chestSessionAddExercise, "Chest Add Exercise");
        WorkoutsPanel chestSessionRemoveExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(0), 1);
        east.add(chestSessionRemoveExercise, "Chest Remove Exercise");

    }


    // MODIFIES: this
    // EFFECTS: initializes all the panels for back
    private void initBackPanel() {
        WorkoutsPanel backPanel = new
                WorkoutManagerPanel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        east.add(backPanel, "Back");
        WorkoutsPanel backAddPanel = new
                WorkoutsEditPanel(this, routine.getMuscleGroups().get(1), 0);
        east.add(backAddPanel, "Back Add");
        WorkoutsPanel backRemovePanel = new
                HandleExercisePanel(this, routine.getMuscleGroups().get(1), 0);
        east.add(backRemovePanel, "Back Remove");
        WorkoutsPanel backEditPanel =
                new WorkoutsEditPanel(this, routine.getMuscleGroups().get(1), 1);
        east.add(backEditPanel, "Back Edit");
        WorkoutsPanel backAddSessionPanel =
                new SessionAddPanel(this, routine.getMuscleGroups().get(1), session, east, eastLayout);
        east.add(backAddSessionPanel, "Back Add Session");
        WorkoutsPanel backSessionAddExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(1), 2);
        east.add(backSessionAddExercise, "Back Add Exercise");
        WorkoutsPanel backSessionRemoveExercise =
                new HandleExercisePanel(this, routine.getMuscleGroups().get(1), 1);
        east.add(backSessionRemoveExercise, "Back Remove Exercise");
    }

    //EFFECTS: finds the correct muscle menu panel to display based on the state of muscle menu panel
    public void findMuscleMenuPanel(int state, String muscleGroupName) {
        switch (state) {
            case 0:
                eastLayout.show(east, muscleGroupName);
                break;
            case 1:
                eastLayout.show(east, muscleGroupName + " Add Session");
                break;
            case 2:
                eastLayout.show(east, muscleGroupName + " Remove Exercise");
        }
    }

    //EFFECTS: finds the session add panel for muscle group and displays it
    public void findSessionAddExercise(String name) {
        switch (name) {
            case "Chest":
                eastLayout.show(east, "Chest Add Exercise");
                break;
            case "Back":
                eastLayout.show(east, "Back Add Exercise");
                break;
            case "Legs":
                eastLayout.show(east, "Legs Add Exercise");
                break;
            case "Tricep":
                eastLayout.show(east, "Triceps Add Exercise");
                break;
            case "Biceps":
                eastLayout.show(east, "Biceps Add Exercise");
                break;
            case "Abs":
                eastLayout.show(east, "Abs Add Exercise");
                break;
            case "Shoulder":
                eastLayout.show(east, "Shoulders Add Exercise");
                break;
        }

    }


    // EFFECTS: Based of the given workout, it finds the correct add panel to display
    public void findAddPanel(Workout w) {
        switch (w.getName()) {
            case "Chest":
                eastLayout.show(east, "Chest Add");
                break;
            case "Back":
                eastLayout.show(east, "Back Add");
                break;
            case "Legs":
                eastLayout.show(east, "Legs Add");
                break;
            case "Tricep":
                eastLayout.show(east, "Triceps Add");
                break;
            case "Biceps":
                eastLayout.show(east, "Biceps Add");
                break;
            case "Abs":
                eastLayout.show(east, "Abs Add");
                break;
            case "Shoulder":
                eastLayout.show(east, "Shoulders Add");
                break;
        }
    }

    // EFFECTS: Based of the given workout, it finds the correct edit panel to display
    public void findEditPanel(Workout w) {
        switch (w.getName()) {
            case "Chest":
                eastLayout.show(east, "Chest Edit");
                break;
            case "Back":
                eastLayout.show(east, "Back Edit");
                break;
            case "Legs":
                eastLayout.show(east, "Legs Edit");
                break;
            case "Tricep":
                eastLayout.show(east, "Triceps Edit");
                break;
            case "Biceps":
                eastLayout.show(east, "Biceps Edit");
                break;
            case "Abs":
                eastLayout.show(east, "Abs Edit");
                break;
            case "Shoulder":
                eastLayout.show(east, "Shoulders Edit");
                break;
        }
    }

    // EFFECTS: Based of the given workout, it finds the correct remove panel to display
    public void findRemovePanel(Workout w) {
        switch (w.getName()) {
            case "Chest":
                eastLayout.show(east, "Chest Remove");
                break;
            case "Back":
                eastLayout.show(east, "Back Remove");
                break;
            case "Legs":
                eastLayout.show(east, "Legs Remove");
                break;
            case "Tricep":
                eastLayout.show(east, "Triceps Remove");
                break;
            case "Biceps":
                eastLayout.show(east, "Biceps Remove");
                break;
            case "Abs":
                eastLayout.show(east, "Abs Remove");
                break;
            case "Shoulder":
                eastLayout.show(east, "Shoulders Remove");
                break;
        }
    }

    //EFFECTS: carries out the appropriate task for remove panel
    public void removePanelOperation(int state, Exercise exercise, Workout workout) {
        switch (state) {
            case 0:
                if (workout.getExercises().contains(exercise)) {
                    workout.removeExercise(exercise);
                }
                repaintPanels();
                updatePanels(workout);
                break;
            case 1:
                session.removeExerciseFromSession(exercise);
                updateViewSessionPanel();
                eastLayout.show(east, "Muscle Menu");
                break;
            case 2:
                session.addExerciseToSession(exercise);
                updateViewSessionPanel();
                eastLayout.show(east, "Muscle Menu");
        }
    }



    // EFFECTS: Updates all panels for given workout
    public void updatePanels(Workout w) {
        switch (w.getName()) {
            case "Chest":
                eastLayout.show(east, "Chest");
                break;
            case "Back":
                eastLayout.show(east, "Back");
                break;
            case "Legs":
                eastLayout.show(east, "Legs");
                break;
            case "Tricep":
                eastLayout.show(east, "Triceps");
                break;
            case "Biceps":
                eastLayout.show(east, "Biceps");
                break;
            case "Abs":
                eastLayout.show(east, "Abs");
                break;
            case "Shoulder":
                eastLayout.show(east, "Shoulders");
                break;
        }
    }


    // EFFECTS: updates the live session panel
    public void updateLiveSessionPanel() {
        new LiveSessionPanel(session, eastLayout, east, this);
    }
}
