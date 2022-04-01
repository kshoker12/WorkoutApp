package ui;

import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the main muscle group panel which lists out all operations which can be done to the muscle group
public class WorkoutManagerPanel extends WorkoutsPanel {
    private JPanel east;
    private CardLayout eastLayout;
    private EastPanelManager managerPanel;

    // EFFECTS: creates the muscle group menu panel as well as buttons for all key features
    public WorkoutManagerPanel(EastPanelManager managerPanel, Workout w, JPanel east, CardLayout eastLayout) {
        super(w);
        this.east = east;
        this.eastLayout = eastLayout;
        this.managerPanel = managerPanel;
        initRemoveExercise();
        initAddExercise();
        initEditExercise();
        initGoBack();
    }

    // EFFECTS: creates the remove exercise button and its behaviour
    private void initRemoveExercise() {
        JButton removeExercise = new JButton("Remove Exercise");
        removeExercise.setPreferredSize(new Dimension(280,30));
        removeExercise.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(removeExercise);
        removeExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                managerPanel.findRemovePanel(getWorkout());
            }
        });
    }

    // EFFECTS: creates the add exercise button and its behaviour
    private void initAddExercise() {
        JButton addExercise = new JButton("Add Exercise");
        addExercise.setPreferredSize(new Dimension(280,30));
        addExercise.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(addExercise);
        addExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                managerPanel.findAddPanel(getWorkout());
            }
        });
    }

    // EFFECTS: creates the edit exercise button and its behaviour
    private void initEditExercise() {
        JButton editExercise = new JButton("Edit Exercise");
        editExercise.setPreferredSize(new Dimension(280,30));
        editExercise.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(editExercise);
        editExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                managerPanel.findEditPanel(getWorkout());
            }
        });
    }

    // EFFECTS: creates the go back button and its behaviour
    private void initGoBack() {
        JButton goBack = new JButton("Go Back");
        goBack.setPreferredSize(new Dimension(280,30));
        goBack.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(goBack);
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Muscle Menu");
            }
        });
    }
}
