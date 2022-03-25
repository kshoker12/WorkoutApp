package ui;

import model.Exercise;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the add exercise panel for muscle groups
public class AddExercisePanel extends MuscleGroupPanel {
    private JPanel east;
    private CardLayout eastLayout;
    private EastPanelManager managerPanel;
    private JTextField exerciseName;
    private JTextField exerciseSets;
    private JTextField exerciseReps;
    private JButton confirm;

    // EFFECTS: constructs the panel as well as the text fields and confirm button
    public AddExercisePanel(EastPanelManager managerPanel, Workout w, JPanel east, CardLayout eastLayout) {
        super(w);
        this.managerPanel = managerPanel;
        this.east = east;
        this.eastLayout = eastLayout;
        initTextFields();
        initConfirm();
    }

    // MODIFIES: this
    // EFFECTS: initializes the confirm button as well as its behaviour
    private void initConfirm() {
        confirm = new JButton("Confirm");
        confirm.setPreferredSize(new Dimension(280, 30));
        this.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercise exercise = new Exercise(exerciseName.getText(), Integer.parseInt(exerciseSets.getText()),
                        Integer.parseInt(exerciseReps.getText()));
                getWorkout().addExercise(exercise);
                MuscleGroupPanel w = managerPanel.getPanelForWorkout(getWorkout());
                MuscleGroupPanel r = managerPanel.getRemovePanel(getWorkout());
                MuscleGroupPanel a = managerPanel.getAddPanel(getWorkout());
                MuscleGroupPanel ed = managerPanel.getEditPanel(getWorkout());
                east.remove(a);
                east.remove(r);
                east.remove(w);
                east.remove(ed);
                clearTextFields();
                managerPanel.updatePanels(getWorkout());
            }
        });
    }

    // EFFECTS: initializes the text fields and instruction labels
    private void initTextFields() {
        this.add(new JLabel("Enter Exercise Name"));
        exerciseName = new JTextField(20);
        exerciseName.setPreferredSize(new Dimension(100, 30));
        exerciseName.setFont(new Font("Arial", Font.ITALIC, 16));
        this.add(exerciseName);
        this.add(new JLabel("Enter # of Sets"));
        exerciseSets = new JTextField(20);
        exerciseSets.setPreferredSize(new Dimension(100, 30));
        exerciseSets.setFont(new Font("Arial", Font.ITALIC, 16));
        this.add(exerciseSets);
        this.add(new JLabel("Enter # of Reps"));
        exerciseReps = new JTextField(20);
        exerciseReps.setPreferredSize(new Dimension(100, 30));
        exerciseReps.setFont(new Font("Arial", Font.ITALIC, 16));
        this.add(exerciseReps);
    }

    // MODIFIES: this
    // EFFECTS: clears the text field
    private void clearTextFields() {
        exerciseName.setText("");
        exerciseReps.setText("");
        exerciseSets.setText("");
    }

}
