package ui;

import model.Exercise;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the remove exercise panel for muscle groups
public class RemoveExercisePanel extends MuscleGroupPanel {
    private JPanel east;
    private CardLayout eastLayout;
    private EastPanelManager managerPanel;
    private JTextField exerciseName;
    private JButton confirm;

    // EFFECTS: constructs the panels and sets up textFields and instruction labels
    public RemoveExercisePanel(EastPanelManager managerPanel, Workout w, JPanel east, CardLayout eastLayout) {
        super(w);
        this.east = east;
        this.eastLayout = eastLayout;
        this.managerPanel = managerPanel;
        initTextFields();
        initConfirm();
    }

    // MODIFIES: east, managerPanel
    // EFFECTS: creates the confirm button as well as its behaviour
    private void initConfirm() {
        confirm = new JButton("Confirm");
        confirm.setPreferredSize(new Dimension(280, 30));
        this.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercise exercise = getWorkout().findExercise(exerciseName.getText());
                if (getWorkout().getExercises().contains(exercise)) {
                    getWorkout().removeExercise(exercise);
                }
                MuscleGroupPanel w = managerPanel.getPanelForWorkout(getWorkout());
                MuscleGroupPanel r = managerPanel.getRemovePanel(getWorkout());
                MuscleGroupPanel a = managerPanel.getAddPanel(getWorkout());
                MuscleGroupPanel ed = managerPanel.getEditPanel(getWorkout());
                east.remove(ed);
                east.remove(a);
                east.remove(r);
                east.remove(w);
                managerPanel.updatePanels(getWorkout());
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
