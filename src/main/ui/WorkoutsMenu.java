package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the menu of all muscle groups listed out
public class WorkoutsMenu extends JPanel {
    private EastPanelManager panelManager;
    private JPanel east;
    private CardLayout eastLayout;
    private int state;

    // EFFECTS: creates the panel for muscle group menu and all the necessary buttons
    public WorkoutsMenu(EastPanelManager panelManager, JPanel east, CardLayout eastLayout, int state) {
        super(new GridLayout(7, 1, 10, 10));
        this.state = state;
        this.east = east;
        this.eastLayout = eastLayout;
        this.east.add(this, "Muscle Menu");
        this.panelManager = panelManager;
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

    public void setState(int state) {
        this.state = state;
    }

    // EFFECTS: creates the chest button and behaviour
    private void createChestButton() {
        JButton chestButton = new JButton("Chest");
        chestButton.setPreferredSize(new Dimension(280,30));
        chestButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(chestButton);
        chestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelManager.findMuscleMenuPanel(state, "Chest");
            }
        });
    }

    // EFFECTS: creates the back button and behaviour
    private void createBackButton() {
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(280,30));
        backButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelManager.findMuscleMenuPanel(state, "Back");
            }
        });
    }

    // EFFECTS: creates the tricep button and behaviour
    private void createTricepButton() {
        JButton tricepButton = new JButton("Triceps");
        tricepButton.setPreferredSize(new Dimension(280,30));
        tricepButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(tricepButton);
        tricepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelManager.findMuscleMenuPanel(state, "Triceps");
            }
        });
    }

    // EFFECTS: creates the bicep button and behaviour
    private void createBicepButton() {
        JButton bicepButton = new JButton("Biceps");
        bicepButton.setPreferredSize(new Dimension(280,30));
        bicepButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(bicepButton);
        bicepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelManager.findMuscleMenuPanel(state, "Biceps");
            }
        });
    }

    // EFFECTS: creates the shoulder button and behaviour
    private void createShoulderButton() {
        JButton shoulderButton = new JButton("Shoulders");
        shoulderButton.setPreferredSize(new Dimension(280,30));
        shoulderButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(shoulderButton);
        shoulderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelManager.findMuscleMenuPanel(state, "Shoulders");
            }
        });
    }

    // EFFECTS: creates the legs button and behaviour
    private void createLegsButton() {
        JButton legsButton = new JButton("Legs");
        legsButton.setPreferredSize(new Dimension(280,30));
        legsButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(legsButton);
        legsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelManager.findMuscleMenuPanel(state, "Legs");
            }
        });
    }

    // EFFECTS: creates the abs button and behaviour
    private void createAbsButton() {
        JButton absButton = new JButton("Abs");
        absButton.setPreferredSize(new Dimension(280,30));
        absButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(absButton);
        absButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelManager.findMuscleMenuPanel(state, "Abs");
            }
        });
    }

    // EFFECTS: creates the go back button and behaviour
    private void createGoBackButton() {
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(280,30));
        goBackButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(goBackButton);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (state == 0) {
                    eastLayout.show(east, "Go Back");
                } else {
                    eastLayout.show(east, "Session Menu");
                }
            }
        });
    }
}
