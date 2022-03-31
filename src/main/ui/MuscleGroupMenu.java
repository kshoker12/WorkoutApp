package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the menu of all muscle groups listed out
public class MuscleGroupMenu extends JPanel {
    private JButton chestButton;
    private JButton backButton;
    private JButton tricepButton;
    private JButton bicepButton;
    private JButton shoulderButton;
    private JButton legsButton;
    private JButton absButton;
    private JButton goBackButton;
    private WorkoutPlannerAppGUI mainFrame;
    private JPanel east;
    private CardLayout eastLayout;

    // EFFECTS: creates the panel for muscle group menu and all the necessary buttons
    public MuscleGroupMenu(WorkoutPlannerAppGUI mainFrame, JPanel east, CardLayout eastLayout) {
        super(new GridLayout(7, 1, 10, 10));
        this.east = east;
        this.eastLayout = eastLayout;
        this.east.add(this, "Muscle Menu");
        this.mainFrame = mainFrame;
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(300, 400));
        createChestButton();
        createBackButton();
        createTricepButton();
        createBicepButton();
        createShoulderButton();
        createLegsButton();
        createAbsButton();
        createGoBackButton();
    }

    // EFFECTS: creates the chest button and behaviour
    private void createChestButton() {
        chestButton = new JButton("Chest");
        chestButton.setPreferredSize(new Dimension(280,30));
        chestButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(chestButton);
        chestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Chest");
            }
        });
    }

    // EFFECTS: creates the back button and behaviour
    private void createBackButton() {
        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(280,30));
        backButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Back");
            }
        });
    }

    // EFFECTS: creates the tricep button and behaviour
    private void createTricepButton() {
        tricepButton = new JButton("Triceps");
        tricepButton.setPreferredSize(new Dimension(280,30));
        tricepButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(tricepButton);
        tricepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Triceps");
            }
        });
    }

    // EFFECTS: creates the bicep button and behaviour
    private void createBicepButton() {
        bicepButton = new JButton("Biceps");
        bicepButton.setPreferredSize(new Dimension(280,30));
        bicepButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(bicepButton);
        bicepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Biceps");
            }
        });
    }

    // EFFECTS: creates the shoulder button and behaviour
    private void createShoulderButton() {
        shoulderButton = new JButton("Shoulders");
        shoulderButton.setPreferredSize(new Dimension(280,30));
        shoulderButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(shoulderButton);
        shoulderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Shoulders");
            }
        });
    }

    // EFFECTS: creates the legs button and behaviour
    private void createLegsButton() {
        legsButton = new JButton("Legs");
        legsButton.setPreferredSize(new Dimension(280,30));
        legsButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(legsButton);
        legsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Legs");
            }
        });
    }

    // EFFECTS: creates the abs button and behaviour
    private void createAbsButton() {
        absButton = new JButton("Abs");
        absButton.setPreferredSize(new Dimension(280,30));
        absButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(absButton);
        absButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Abs");
            }
        });
    }

    // EFFECTS: creates the go back button and behaviour
    private void createGoBackButton() {
        goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(280,30));
        goBackButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(goBackButton);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                eastLayout.show(east, "Go Back");
            }
        });
    }
}
