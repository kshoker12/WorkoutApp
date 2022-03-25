package ui;

import model.Routine;
import model.Session;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Manages all the panels which can be displayed on the East of the Workout Window
public class EastPanelManager {
    private List<MuscleGroupPanel> panels;
    private JPanel east;
    private CardLayout eastLayout;
    private Routine routine;
    private List<MuscleGroupPanel> addPanels;
    private List<MuscleGroupPanel> removePanels;
    private List<MuscleGroupPanel> editPanels;
    private List<MuscleGroupPanel> sessionMuscleGroupAddPanels;
    private Session session;
    private ViewSessionPanel viewSessionPanel;
    private LiveSessionPanel liveSessionPanel;

    // EFFECTS: creates all the panels and also creates lists which hold each category of panels
    public EastPanelManager(Session session, Routine routine, JPanel east, CardLayout eastLayout) {
        panels = new ArrayList<>();
        addPanels = new ArrayList<>();
        removePanels = new ArrayList<>();
        editPanels = new ArrayList<>();
        sessionMuscleGroupAddPanels = new ArrayList<>();
        liveSessionPanel = new LiveSessionPanel(session, eastLayout, east, this);
        this.session = session;
        this.east = east;
        this.routine = routine;
        this.eastLayout = eastLayout;
        viewSessionPanel = new ViewSessionPanel(session, east, eastLayout);
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
        viewSessionPanel = new ViewSessionPanel(session, east, eastLayout);
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for abs
    private void initAbsPanel() {
        initAbsNormalPanel();
        MuscleGroupPanel absAddPanel = new
                AddExercisePanel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        east.add(absAddPanel, "Abs Add");
        addPanels.add(absAddPanel);
        MuscleGroupPanel absRemovePanel = new
                RemoveExercisePanel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        east.add(absRemovePanel, "Abs Remove");
        removePanels.add(absRemovePanel);
        MuscleGroupPanel absEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        east.add(absEditPanel, "Abs Edit");
        editPanels.add(absEditPanel);
        MuscleGroupPanel absAddSessionPanel =
                new SessionMuscleGroupAddPanel(this, routine.getMuscleGroups().get(6), session, east, eastLayout);
        east.add(absAddSessionPanel, "Abs Add Session");
        sessionMuscleGroupAddPanels.add(absAddSessionPanel);
        MuscleGroupPanel absSessionAddExercise =
                new SessionAddExercisePanel(this, routine.getMuscleGroups().get(6), session, east, eastLayout);
        east.add(absSessionAddExercise, "Abs Add Exercise");
        MuscleGroupPanel absSessionRemoveExercise =
                new SessionRemoveExercisePanel(this, routine.getMuscleGroups().get(6), session, east, eastLayout);
        east.add(absSessionRemoveExercise, "Abs Remove Exercise");
    }

    // MODIFIES: east, panels
    // EFFECTS: initializes the original abs panel
    private void initAbsNormalPanel() {
        MuscleGroupPanel absPanel = new
                MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        east.add(absPanel, "Abs");
        panels.add(absPanel);
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for legs
    private void initLegsPanel() {
        initLegNormalPanel();
        MuscleGroupPanel addLegsPanel = new
                AddExercisePanel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        east.add(addLegsPanel, "Legs Add");
        addPanels.add(addLegsPanel);
        MuscleGroupPanel legsRemovePanel = new
                RemoveExercisePanel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        east.add(legsRemovePanel, "Legs Remove");
        removePanels.add(legsRemovePanel);
        MuscleGroupPanel legsEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        east.add(legsEditPanel, "Legs Edit");
        editPanels.add(legsEditPanel);
        MuscleGroupPanel legsAddSessionPanel =
                new SessionMuscleGroupAddPanel(this, routine.getMuscleGroups().get(5), session, east, eastLayout);
        east.add(legsAddSessionPanel, "Legs Add Session");
        sessionMuscleGroupAddPanels.add(legsAddSessionPanel);
        MuscleGroupPanel legsSessionAddExercise =
                new SessionAddExercisePanel(this, routine.getMuscleGroups().get(5), session, east, eastLayout);
        east.add(legsSessionAddExercise, "Legs Add Exercise");
        MuscleGroupPanel legsSessionRemoveExercise =
                new SessionRemoveExercisePanel(this, routine.getMuscleGroups().get(5), session, east, eastLayout);
        east.add(legsSessionRemoveExercise, "Legs Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes the normal leg panel
    private void initLegNormalPanel() {
        MuscleGroupPanel legsPanel = new
                MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        east.add(legsPanel, "Legs");
        panels.add(legsPanel);
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for shoulders
    private void initShouldersPanel() {
        initNormalShoulderPanel();
        MuscleGroupPanel shouldersAddPanel = new
                AddExercisePanel(this, routine.getMuscleGroups().get(4), east, eastLayout);
        east.add(shouldersAddPanel, "Shoulders Add");
        addPanels.add(shouldersAddPanel);
        MuscleGroupPanel shouldersRemovePanel = new
                RemoveExercisePanel(this, routine.getMuscleGroups().get(4), east, eastLayout);
        east.add(shouldersRemovePanel, "Shoulders Remove");
        removePanels.add(shouldersRemovePanel);
        MuscleGroupPanel shouldersEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(4), east, eastLayout);
        east.add(shouldersEditPanel, "Shoulders Edit");
        editPanels.add(shouldersEditPanel);
        MuscleGroupPanel shoulderAddSessionPanel =
                new SessionMuscleGroupAddPanel(this, routine.getMuscleGroups().get(4), session, east, eastLayout);
        east.add(shoulderAddSessionPanel, "Shoulders Add Session");
        sessionMuscleGroupAddPanels.add(shoulderAddSessionPanel);
        MuscleGroupPanel shouldersSessionAddExercise =
                new SessionAddExercisePanel(this, routine.getMuscleGroups().get(4), session, east, eastLayout);
        east.add(shouldersSessionAddExercise, "Shoulders Add Exercise");
        MuscleGroupPanel shouldersSessionRemoveExercise =
                new SessionRemoveExercisePanel(this, routine.getMuscleGroups().get(4), session, east, eastLayout);
        east.add(shouldersSessionRemoveExercise, "Shoulders Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes the normal shoulder panel
    private void initNormalShoulderPanel() {
        MuscleGroupPanel shoulderPanel = new
                MuscleGroupMenuPanel(this,routine.getMuscleGroups().get(4), east, eastLayout);
        east.add(shoulderPanel, "Shoulders");
        panels.add(shoulderPanel);
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for biceps
    private void initBicepPanel() {
        initNormalBicepPanel();
        MuscleGroupPanel bicepAddPanel = new
                AddExercisePanel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        east.add(bicepAddPanel, "Bicep Add");
        addPanels.add(bicepAddPanel);
        MuscleGroupPanel bicepRemovePanel = new
                RemoveExercisePanel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        east.add(bicepRemovePanel, "Bicep Remove");
        removePanels.add(bicepRemovePanel);
        MuscleGroupPanel bicepEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        east.add(bicepEditPanel, "Bicep Edit");
        editPanels.add(bicepEditPanel);
        MuscleGroupPanel bicepAddSessionPanel =
                new SessionMuscleGroupAddPanel(this, routine.getMuscleGroups().get(3), session, east, eastLayout);
        east.add(bicepAddSessionPanel, "Bicep Add Session");
        sessionMuscleGroupAddPanels.add(bicepAddSessionPanel);
        MuscleGroupPanel bicepSessionAddExercise =
                new SessionAddExercisePanel(this, routine.getMuscleGroups().get(3), session, east, eastLayout);
        east.add(bicepSessionAddExercise, "Bicep Add Exercise");
        MuscleGroupPanel bicepSessionRemoveExercise =
                new SessionRemoveExercisePanel(this, routine.getMuscleGroups().get(3), session, east, eastLayout);
        east.add(bicepSessionRemoveExercise, "Bicep Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes the normal leg panel
    private void initNormalBicepPanel() {
        MuscleGroupPanel bicepPanel = new
                MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        east.add(bicepPanel, "Biceps");
        panels.add(bicepPanel);
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for triceps
    private void initTricepPanel() {
        initTricepNormalPanel();
        MuscleGroupPanel tricepAddPanel = new
                AddExercisePanel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        east.add(tricepAddPanel, "Triceps Add");
        addPanels.add(tricepAddPanel);
        MuscleGroupPanel tricepRemovePanel = new
                RemoveExercisePanel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        east.add(tricepRemovePanel, "Triceps Remove");
        removePanels.add(tricepRemovePanel);
        MuscleGroupPanel tricepsEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        east.add(tricepsEditPanel, "Triceps Edit");
        editPanels.add(tricepsEditPanel);
        MuscleGroupPanel tricepAddSessionPanel =
                new SessionMuscleGroupAddPanel(this, routine.getMuscleGroups().get(2), session, east, eastLayout);
        east.add(tricepAddSessionPanel, "Triceps Add Session");
        sessionMuscleGroupAddPanels.add(tricepAddSessionPanel);
        MuscleGroupPanel tricepSessionAddExercise =
                new SessionAddExercisePanel(this, routine.getMuscleGroups().get(2), session, east, eastLayout);
        east.add(tricepSessionAddExercise, "Triceps Add Exercise");
        MuscleGroupPanel tricepsSessionRemoveExercise =
                new SessionRemoveExercisePanel(this, routine.getMuscleGroups().get(2), session, east, eastLayout);
        east.add(tricepsSessionRemoveExercise, "Triceps Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes the normal tricep panel
    private void initTricepNormalPanel() {
        MuscleGroupPanel tricepPanel = new
                MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        east.add(tricepPanel, "Triceps");
        panels.add(tricepPanel);
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for chest
    private void initChestPanel() {
        initChestNormalPanel();
        MuscleGroupPanel chestAddPanel = new
                AddExercisePanel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        east.add(chestAddPanel, "Chest Add");
        addPanels.add(chestAddPanel);
        MuscleGroupPanel chestRemovePanel = new
                RemoveExercisePanel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        east.add(chestRemovePanel, "Chest Remove");
        removePanels.add(chestRemovePanel);
        MuscleGroupPanel chestEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        east.add(chestEditPanel, "Chest Edit");
        editPanels.add(chestEditPanel);
        MuscleGroupPanel chestAddSessionPanel =
                new SessionMuscleGroupAddPanel(this, routine.getMuscleGroups().get(0), session, east, eastLayout);
        east.add(chestAddSessionPanel, "Chest Add Session");
        sessionMuscleGroupAddPanels.add(chestAddSessionPanel);
        MuscleGroupPanel chestSessionAddExercise =
                new SessionAddExercisePanel(this, routine.getMuscleGroups().get(0), session, east, eastLayout);
        east.add(chestSessionAddExercise, "Chest Add Exercise");
        MuscleGroupPanel chestSessionRemoveExercise =
                new SessionRemoveExercisePanel(this, routine.getMuscleGroups().get(0), session, east, eastLayout);
        east.add(chestSessionRemoveExercise, "Chest Remove Exercise");

    }

    // MODIFIES: this
    // EFFECTS: initializes the normal chest panel
    private void initChestNormalPanel() {
        MuscleGroupPanel chestPanel = new
                MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        east.add(chestPanel, "Chest");
        panels.add(chestPanel);
    }

    // MODIFIES: this
    // EFFECTS: initializes all the panels for back
    private void initBackPanel() {
        initNormalBackPanel();
        MuscleGroupPanel backAddPanel = new
                AddExercisePanel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        east.add(backAddPanel, "Back Add");
        addPanels.add(backAddPanel);
        MuscleGroupPanel backRemovePanel = new
                RemoveExercisePanel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        east.add(backRemovePanel, "Back Remove");
        removePanels.add(backRemovePanel);
        MuscleGroupPanel backEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        east.add(backEditPanel, "Back Edit");
        editPanels.add(backEditPanel);
        MuscleGroupPanel backAddSessionPanel =
                new SessionMuscleGroupAddPanel(this, routine.getMuscleGroups().get(1), session, east, eastLayout);
        east.add(backAddSessionPanel, "Back Add Session");
        sessionMuscleGroupAddPanels.add(backAddPanel);
        MuscleGroupPanel backSessionAddExercise =
                new SessionAddExercisePanel(this, routine.getMuscleGroups().get(1), session, east, eastLayout);
        east.add(backSessionAddExercise, "Back Add Exercise");
        MuscleGroupPanel backSessionRemoveExercise =
                new SessionRemoveExercisePanel(this, routine.getMuscleGroups().get(1), session, east, eastLayout);
        east.add(backSessionRemoveExercise, "Back Remove Exercise");
    }

    // MODIFIES: this
    // EFFECTS: initializes the normal back panel
    private void initNormalBackPanel() {
        MuscleGroupPanel backPanel = new
                MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        east.add(backPanel, "Back");
        panels.add(backPanel);
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
            case "Bicep":
                eastLayout.show(east, "Bicep Add Exercise");
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
            case "Bicep":
                eastLayout.show(east, "Bicep Add");
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
            case "Bicep":
                eastLayout.show(east, "Bicep Edit");
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
            case "Bicep":
                eastLayout.show(east, "Bicep Remove");
                break;
            case "Abs":
                eastLayout.show(east, "Abs Remove");
                break;
            case "Shoulder":
                eastLayout.show(east, "Shoulders Remove");
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: finds the correct panel for given workout and removes it from panels and returns the panel if found
    public MuscleGroupPanel getPanelForWorkout(Workout w) {
        for (MuscleGroupPanel panel: panels) {
            if (panel.getWorkout().equals(w)) {
                panels.remove(panel);
                return panel;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: finds the correct remove panel for given workout and removes it from removePanels and returns
    // the panel if found
    public MuscleGroupPanel getRemovePanel(Workout w) {
        for (MuscleGroupPanel panel: removePanels) {
            if (panel.getWorkout().equals(w)) {
                removePanels.remove(panel);
                return panel;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: finds the correct add panel for given workout and removes it from addPanels and
    // returns the panel if found
    public MuscleGroupPanel getAddPanel(Workout w) {
        for (MuscleGroupPanel panel: addPanels) {
            if (panel.getWorkout().equals(w)) {
                addPanels.remove(panel);
                return panel;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: finds the correct edit panel for given workout and removes it from editPanels
    // and returns the panel if found
    public MuscleGroupPanel getEditPanel(Workout w) {
        for (MuscleGroupPanel panel: editPanels) {
            if (panel.getWorkout().equals(w)) {
                editPanels.remove(panel);
                return panel;
            }
        }
        return null;
    }

    // EFFECTS: Updates all panels for given workout
    public void updatePanels(Workout w) {
        switch (w.getName()) {
            case "Chest":
                updateChest();
                break;
            case "Back":
                updateBack();
                break;
            case "Legs":
                updateLegs();
                break;
            case "Tricep":
                updateTricep();
                break;
            case "Bicep":
                updateBicep();
                break;
            case "Abs":
                updateAbs();
                break;
            case "Shoulder":
                updateShoulder();
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: updates all shoulder panels and displays main panel
    private void updateShoulder() {
        MuscleGroupPanel shoulderPanel =
                new MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(4), east, eastLayout);
        east.add(shoulderPanel, "Shoulders");
        panels.add(shoulderPanel);
        MuscleGroupPanel shoulderRemovePanel =
                new RemoveExercisePanel(this, routine.getMuscleGroups().get(4), east, eastLayout);
        removePanels.add(shoulderRemovePanel);
        east.add(shoulderRemovePanel, "Shoulders Remove");
        MuscleGroupPanel shoulderAddPanel =
                new AddExercisePanel(this, routine.getMuscleGroups().get(4), east, eastLayout);
        addPanels.add(shoulderAddPanel);
        east.add(shoulderAddPanel, "Shoulders Add");
        MuscleGroupPanel shoulderEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(4), east, eastLayout);
        editPanels.add(shoulderEditPanel);
        east.add(shoulderEditPanel, "Shoulders Edit");
        east.revalidate();
        east.repaint();
        eastLayout.show(east, "Shoulders");
    }

    // MODIFIES: this
    // EFFECTS: updates all abs panels and displays main panel
    private void updateAbs() {
        MuscleGroupPanel absPanel =
                new MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        east.add(absPanel, "Abs");
        panels.add(absPanel);
        MuscleGroupPanel absRemovePanel =
                new RemoveExercisePanel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        removePanels.add(absRemovePanel);
        east.add(absRemovePanel, "Abs Remove");
        MuscleGroupPanel absAddPanel =
                new AddExercisePanel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        addPanels.add(absAddPanel);
        east.add(absAddPanel, "Abs Add");
        MuscleGroupPanel absEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(6), east, eastLayout);
        editPanels.add(absEditPanel);
        east.add(absEditPanel, "Abs Edit");
        east.revalidate();
        east.repaint();
        eastLayout.show(east, "Abs");
    }

    // MODIFIES: this
    // EFFECTS: updates all bicep panels and displays main panel
    private void updateBicep() {
        MuscleGroupPanel bicepPanel =
                new MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        east.add(bicepPanel, "Bicep");
        panels.add(bicepPanel);
        MuscleGroupPanel bicepRemovePanel =
                new RemoveExercisePanel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        removePanels.add(bicepRemovePanel);
        east.add(bicepRemovePanel, "Bicep Remove");
        MuscleGroupPanel bicepAddPanel =
                new AddExercisePanel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        addPanels.add(bicepAddPanel);
        east.add(bicepAddPanel, "Bicep Add");
        MuscleGroupPanel bicepEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(3), east, eastLayout);
        editPanels.add(bicepEditPanel);
        east.add(bicepEditPanel, "Bicep Edit");
        east.revalidate();
        east.repaint();
        eastLayout.show(east, "Bicep");
    }

    // MODIFIES: this
    // EFFECTS: updates all tricep panels and displays main panel
    private void updateTricep() {
        MuscleGroupPanel chestPanel =
                new MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        east.add(chestPanel, "Triceps");
        panels.add(chestPanel);
        MuscleGroupPanel tricepRemovePanel =
                new RemoveExercisePanel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        removePanels.add(tricepRemovePanel);
        east.add(tricepRemovePanel, "Triceps Remove");
        MuscleGroupPanel tricepAddPanel =
                new AddExercisePanel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        addPanels.add(tricepAddPanel);
        east.add(tricepAddPanel, "Triceps Add");
        MuscleGroupPanel tricepsEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(2), east, eastLayout);
        editPanels.add(tricepsEditPanel);
        east.add(tricepsEditPanel, "Triceps Edit");
        east.revalidate();
        east.repaint();
        eastLayout.show(east, "Triceps");
    }

    // MODIFIES: this
    // EFFECTS: updates all legs panels and displays main panel
    private void updateLegs() {
        MuscleGroupPanel legPanel =
                new MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        east.add(legPanel, "Legs");
        panels.add(legPanel);
        MuscleGroupPanel legsRemovePanel =
                new RemoveExercisePanel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        removePanels.add(legsRemovePanel);
        east.add(legsRemovePanel, "Legs Remove");
        MuscleGroupPanel legsAddPanel =
                new AddExercisePanel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        addPanels.add(legsAddPanel);
        east.add(legsAddPanel, "Legs Add");
        MuscleGroupPanel legsEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(5), east, eastLayout);
        editPanels.add(legsEditPanel);
        east.add(legsEditPanel, "Legs Edit");
        east.revalidate();
        east.repaint();
        eastLayout.show(east, "Legs");
    }

    // MODIFIES: this
    // EFFECTS: updates all back panels and displays main panel
    private void updateBack() {
        MuscleGroupPanel backPanel =
                new MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        east.add(backPanel, "Back");
        panels.add(backPanel);
        MuscleGroupPanel backRemovePanel =
                new RemoveExercisePanel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        removePanels.add(backRemovePanel);
        east.add(backRemovePanel, "Back Remove");
        MuscleGroupPanel backAddPanel =
                new AddExercisePanel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        addPanels.add(backAddPanel);
        east.add(backAddPanel, "Back Add");
        MuscleGroupPanel backEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(1), east, eastLayout);
        editPanels.add(backEditPanel);
        east.add(backEditPanel, "Back Edit");
        east.revalidate();
        east.repaint();
        eastLayout.show(east, "Back");
    }

    // MODIFIES: this
    // EFFECTS: updates all chest panels and displays main panel
    private void updateChest() {
        MuscleGroupPanel chestPanel =
                new MuscleGroupMenuPanel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        east.add(chestPanel, "Chest");
        panels.add(chestPanel);
        MuscleGroupPanel chestRemovePanel =
                new RemoveExercisePanel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        removePanels.add(chestRemovePanel);
        east.add(chestRemovePanel, "Chest Remove");
        MuscleGroupPanel chestAddPanel =
                new AddExercisePanel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        addPanels.add(chestAddPanel);
        east.add(chestAddPanel, "Chest Add");
        MuscleGroupPanel chestEditPanel =
                new EditExercisePannel(this, routine.getMuscleGroups().get(0), east, eastLayout);
        editPanels.add(chestEditPanel);
        east.add(chestEditPanel, "Chest Edit");
        east.revalidate();
        east.repaint();
        eastLayout.show(east, "Chest");
    }

    // EFFECTS: updates the live session panel
    public void updateLiveSessionPanel() {
        liveSessionPanel = new LiveSessionPanel(session, eastLayout, east, this);
    }
}
