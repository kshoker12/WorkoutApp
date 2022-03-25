package ui;

import model.Exercise;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents the edit exercise panel where exercises can be edited
public class EditExercisePannel extends MuscleGroupPanel {
    private JPanel east;
    private CardLayout eastLayout;
    private EastPanelManager managerPanel;
    private JTextField exerciseName;
    private JTextField exerciseSets;
    private JTextField exerciseReps;
    private JButton confirm;

    // EFFECTS: creates the panel and sets up the text fields and confirm button
    public EditExercisePannel(EastPanelManager managerPanel, Workout w, JPanel east, CardLayout eastLayout) {
        super(w);
        this.east = east;
        this.eastLayout = eastLayout;
        this.managerPanel = managerPanel;
        initTextFields();
        initConfirm();
    }

    // MODIFIES: this
    // EFFECTS: creates the confirm button and its behaviour
    private void initConfirm() {
        confirm = new JButton("Confirm");
        confirm.setPreferredSize(new Dimension(280, 30));
        this.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercise exercise = getWorkout().findExercise(exerciseName.getText());
                if (exercise != null) {
                    exercise.setReps(Integer.parseInt(exerciseReps.getText()));
                    exercise.setSets(Integer.parseInt(exerciseSets.getText()));
                }
                MuscleGroupPanel w = managerPanel.getPanelForWorkout(getWorkout());
                MuscleGroupPanel r = managerPanel.getRemovePanel(getWorkout());
                MuscleGroupPanel a = managerPanel.getAddPanel(getWorkout());
                MuscleGroupPanel ed = managerPanel.getEditPanel(getWorkout());
                east.remove(a);
                east.remove(r);
                east.remove(w);
                east.remove(ed);
                managerPanel.updatePanels(getWorkout());
                clearTextFields();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: clears all the text fields
    private void clearTextFields() {
        exerciseName.setText("");
        exerciseReps.setText("");
        exerciseSets.setText("");
    }

    // EFFECTS: creates the text fields and instruction labels
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
}
