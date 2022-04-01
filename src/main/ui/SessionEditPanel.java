package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the session menu panel and allows you to conduct operations on session
public class SessionEditPanel extends JPanel {
    private JPanel east;
    private CardLayout eastLayout;
    private WorkoutsMenu musclePanel;

    // EFFECTS: constructs the session panel and all its buttons
    public SessionEditPanel(WorkoutsMenu menu, JPanel east, CardLayout eastLayout) {
        this.east = east;
        this.eastLayout = eastLayout;
        this.east.add(this, "Session Menu");
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(300, 400));
        this.musclePanel = menu;
        createAddExercises();
        createRemoveExercise();
        createGoBack();
    }

    // MODIFIES: this,
    // EFFECTS: Creates the go back button and its behaviour
    private void createGoBack() {
        JButton goBackButton = new JButton("Go Back");
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
        JButton removeExerciseButton = new JButton("Remove Exercise");
        removeExerciseButton.setPreferredSize(new Dimension(280,30));
        removeExerciseButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(removeExerciseButton);
        removeExerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musclePanel.setState(2);
                eastLayout.show(east, "Muscle Menu");
            }
        });
    }

    // MODIFIES: this,
    // EFFECTS: Creates the add exercise button and its behaviour
    private void createAddExercises() {
        JButton addExercisesButton = new JButton("Add Exercises");
        addExercisesButton.setPreferredSize(new Dimension(280,30));
        addExercisesButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(addExercisesButton);
        addExercisesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musclePanel.setState(1);
                eastLayout.show(east, "Muscle Menu");
            }
        });
    }
}
