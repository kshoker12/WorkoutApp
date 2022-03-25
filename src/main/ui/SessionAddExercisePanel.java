package ui;

import model.Exercise;
import model.Routine;
import model.Session;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the session add exercise panel which is used to add exercises to session
public class SessionAddExercisePanel extends MuscleGroupPanel {
    private JPanel east;
    private CardLayout eastLayout;
    private EastPanelManager managerPanel;
    private JTextField exerciseName;
    private JButton confirm;
    private Session session;

    // EFFECTS: sets up the panel and all its features
    public SessionAddExercisePanel(EastPanelManager m, Workout w,
                                   Session session, JPanel east, CardLayout eastLayout) {
        super(w);
        this.east = east;
        managerPanel = m;
        this.eastLayout = eastLayout;
        this.session = session;
        initTextFields();
        initConfirm();
    }

    // EFFECTS: initializes the confirm button and its behaviour
    private void initConfirm() {
        confirm = new JButton("Confirm");
        confirm.setPreferredSize(new Dimension(280, 30));
        this.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercise exercise = getWorkout().findExercise(exerciseName.getText());
                session.addExerciseToSession(exercise);
                managerPanel.updateViewSessionPanel();
                clearTextFields();
                eastLayout.show(east, "Session Muscle Group");
            }
        });
    }

    // EFFECTS: initializes the text field
    private void initTextFields() {
        this.add(new JLabel("Enter Exercise Name"));
        exerciseName = new JTextField(20);
        exerciseName.setPreferredSize(new Dimension(100, 30));
        exerciseName.setFont(new Font("Arial", Font.ITALIC, 16));
        this.add(exerciseName);

    }

    // MODIFIES: this
    // EFFECTS: clears the text field
    private void clearTextFields() {
        exerciseName.setText("");
    }
}
