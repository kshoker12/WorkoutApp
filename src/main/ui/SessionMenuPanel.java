package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the session menu panel and allows you to conduct operations on session
public class SessionMenuPanel extends JPanel {
    private JButton addExercisesButton;
    private JButton removeExerciseButton;
    private JButton goBackButton;
    private WorkoutPlannerAppGUI mainFrame;
    private JPanel east;
    private CardLayout eastLayout;
    private SessionAddMusclePanel musclePanel;
    private SessionRemoveMusclePanel removeMusclePanel;

    // EFFECTS: constructs the session panel and all its buttons
    public SessionMenuPanel(WorkoutPlannerAppGUI mainFrame, JPanel east, CardLayout eastLayout) {
        this.east = east;
        this.eastLayout = eastLayout;
        this.east.add(this, "Session Menu");
        this.mainFrame = mainFrame;
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(300, 400));
        musclePanel = new SessionAddMusclePanel(east, eastLayout);
        removeMusclePanel = new SessionRemoveMusclePanel(east, eastLayout);
        createAddExercises();
        createRemoveExercise();
        createGoBack();
    }

    // MODIFIES: this,
    // EFFECTS: Creates the go back button and its behaviour
    private void createGoBack() {
        goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(280,30));
        goBackButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(goBackButton);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Go Back");
            }
        });
    }

    // MODIFIES: this,
    // EFFECTS: Creates the remove exercise button and its behaviour
    private void createRemoveExercise() {
        removeExerciseButton = new JButton("Remove Exercise");
        removeExerciseButton.setPreferredSize(new Dimension(280,30));
        removeExerciseButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(removeExerciseButton);
        removeExerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Session Muscle Remove");
            }
        });
    }

    // MODIFIES: this,
    // EFFECTS: Creates the add exercise button and its behaviour
    private void createAddExercises() {
        addExercisesButton = new JButton("Add Exercises");
        addExercisesButton.setPreferredSize(new Dimension(280,30));
        addExercisesButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(addExercisesButton);
        addExercisesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Session Muscle Group");
            }
        });
    }
}
