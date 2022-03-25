package ui;

import model.Session;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the session muscle group add panel
public class SessionMuscleGroupAddPanel extends MuscleGroupPanel {
    private JButton addMuscleGroupButton;
    private JButton addSingleExerciseButton;
    private JButton goBackButton;
    private Session session;
    private Workout workout;
    private JPanel east;
    private CardLayout eastLayout;
    private EastPanelManager panelManager;


    // EFFECTS: sets up the panel an all its features
    public SessionMuscleGroupAddPanel(EastPanelManager m,
                                      Workout w, Session session, JPanel east, CardLayout eastLayout) {
        super(w);
        this.session = session;
        panelManager = m;
        this.east = east;
        this.eastLayout = eastLayout;
        createAddMuscleGroupButton();
        createAddSingleExerciseButton();
        createGoBackButton();
    }

    // EFFECTS: sets up the go back button and its behaviour
    private void createGoBackButton() {
        goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(280,30));
        goBackButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(goBackButton);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Session Muscle Group");
            }
        });
    }

    // EFFECTS: sets up the add single exercise button and its behaviour
    private void createAddSingleExerciseButton() {
        addSingleExerciseButton = new JButton("Add Exercise");
        addSingleExerciseButton.setPreferredSize(new Dimension(280,30));
        addSingleExerciseButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(addSingleExerciseButton);
        addSingleExerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.findSessionAddExercise(getWorkout().getName());
            }
        });
    }

    // EFFECTS: sets up the add muscle group button and its behaviour
    private void createAddMuscleGroupButton() {
        addMuscleGroupButton = new JButton("Add Muscle Group");
        addMuscleGroupButton.setPreferredSize(new Dimension(280,30));
        addMuscleGroupButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(addMuscleGroupButton);
        addMuscleGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                session.addMuscleGroup(getWorkout());
                panelManager.updateViewSessionPanel();
                eastLayout.show(east, "Session Muscle Group");
            }
        });
    }


}

