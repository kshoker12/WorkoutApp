package ui;

import model.Exercise;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the edit muscle group panel for muscle groups
public class WorkoutsEditPanel extends WorkoutsPanel {
    private EastPanelManager managerPanel;
    private JTextField exerciseName;
    private JTextField exerciseSets;
    private JTextField exerciseReps;
    private int state;

    // EFFECTS: constructs the panel as well as the text fields and confirm button
    public WorkoutsEditPanel(EastPanelManager managerPanel, Workout w, int state) {
        super(w);
        this.managerPanel = managerPanel;
        this.state = state;
        initTextFields();
        initConfirm();
    }

    // MODIFIES: this
    // EFFECTS: initializes the confirm button as well as its behaviour
    private void initConfirm() {
        JButton confirm = new JButton("Confirm");
        confirm.setPreferredSize(new Dimension(280, 30));
        this.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == 0) {
                    Exercise exercise = new Exercise(exerciseName.getText(), Integer.parseInt(exerciseSets.getText()),
                            Integer.parseInt(exerciseReps.getText()));
                    getWorkout().addExercise(exercise);
                } else {
                    Exercise exercise = getWorkout().findExercise(exerciseName.getText());
                    if (exercise != null) {
                        exercise.editExercise(Integer.parseInt(exerciseSets.getText()),
                                Integer.parseInt(exerciseReps.getText()));
                    }
                }
                clearTextFields();
                managerPanel.repaintPanels();
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
