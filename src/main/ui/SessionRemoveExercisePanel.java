package ui;

import model.Exercise;
import model.Session;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the session remove exercise panel where we can remove exercises
public class SessionRemoveExercisePanel extends MuscleGroupPanel {
    private Session session;
    private JPanel east;
    private CardLayout eastLayout;
    private JTextField exerciseName;
    private JButton confirmButton;
    private EastPanelManager panelManager;

    // EFFECTS: sets up the remove exercise panel and all its features
    public SessionRemoveExercisePanel(EastPanelManager m, Workout w,
                                      Session session, JPanel east, CardLayout eastLayout) {
        super(w);
        panelManager = m;
        this.session = session;
        this.east = east;
        this.eastLayout = eastLayout;
        initTextFields();
        initConfirm();
    }

    // MODIFIES: session
    // EFFECTS: initializes the confirm button and its behaviour
    private void initConfirm() {
        confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(new Dimension(280, 30));
        this.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercise exercise = getWorkout().findExercise(exerciseName.getText());
                session.removeExerciseFromSession(exercise);
                panelManager.updateViewSessionPanel();
                eastLayout.show(east, "Session Muscle Group");
                exerciseName.setText("");
            }
        });
    }

    // EFFECTS: initializes the text field to enter exercise name
    private void initTextFields() {
        this.add(new JLabel("Enter Exercise Name"));
        exerciseName = new JTextField(20);
        exerciseName.setPreferredSize(new Dimension(100, 30));
        exerciseName.setFont(new Font("Arial", Font.ITALIC, 16));
        this.add(exerciseName);
    }


}
