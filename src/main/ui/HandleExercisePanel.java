package ui;

import model.Exercise;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Handles the exercise given by user and conducts operation based on state for muscle groups
public class HandleExercisePanel extends WorkoutsPanel {
    private EastPanelManager managerPanel;
    private JTextField exerciseName;
    private int state;

    // EFFECTS: constructs the panels and sets up textFields and instruction labels
    public HandleExercisePanel(EastPanelManager managerPanel, Workout w, int state) {
        super(w);
        this.state = state;
        this.managerPanel = managerPanel;
        initTextFields();
        initConfirm();
    }

    // MODIFIES: east, managerPanel
    // EFFECTS: creates the confirm button as well as its behaviour
    private void initConfirm() {
        JButton confirm = new JButton("Confirm");
        confirm.setPreferredSize(new Dimension(280, 30));
        this.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercise exercise = getWorkout().findExercise(exerciseName.getText());
                managerPanel.removePanelOperation(state, exercise, getWorkout());
                exerciseName.setText("");
            }
        });
    }

    // EFFECTS: sets up all the text fields and instruction labels
    private void initTextFields() {
        this.add(new JLabel("Enter Exercise Name"));
        exerciseName = new JTextField(20);
        exerciseName.setPreferredSize(new Dimension(100, 30));
        exerciseName.setFont(new Font("Arial", Font.ITALIC, 16));
        this.add(exerciseName);
    }
}
