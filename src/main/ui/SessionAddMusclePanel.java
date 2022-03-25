package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the sessions add muscle group panel used to add entire muscle groups to session
public class SessionAddMusclePanel extends JPanel {
    private JButton chestButton;
    private JButton backButton;
    private JButton tricepButton;
    private JButton bicepButton;
    private JButton shoulderButton;
    private JButton legsButton;
    private JButton absButton;
    private JButton goBackButton;
    private JPanel east;
    private CardLayout eastLayout;

    // EFFECTS: sets up panel and all its given features
    public SessionAddMusclePanel(JPanel east, CardLayout eastLayout) {
        super(new GridLayout(7, 1, 10, 10));
        this.east = east;
        this.eastLayout = eastLayout;
        this.east.add(this, "Session Muscle Group");
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

    // EFFECTS: sets up the go back button and its behaviour
    private void createGoBackButton() {
        goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(280,30));
        goBackButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(goBackButton);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Session Menu");
            }
        });
    }

    // EFFECTS: sets up the abs exercise button and its behaviour
    private void createAbsButton() {
        absButton = new JButton("Abs");
        absButton.setPreferredSize(new Dimension(280,30));
        absButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(absButton);
        absButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Abs Add Session");
            }
        });
    }

    // EFFECTS: sets up the legs exercise button and its behaviour
    private void createLegsButton() {
        legsButton = new JButton("Legs");
        legsButton.setPreferredSize(new Dimension(280,30));
        legsButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(legsButton);
        legsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Legs Add Session");
            }
        });
    }

    // EFFECTS: sets up the shoulder exercise button and its behaviour
    private void createShoulderButton() {
        shoulderButton = new JButton("Shoulders");
        shoulderButton.setPreferredSize(new Dimension(280,30));
        shoulderButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(shoulderButton);
        shoulderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Shoulders Add Session");
            }
        });
    }

    // EFFECTS: sets up the biceps exercise button and its behaviour
    private void createBicepButton() {
        bicepButton = new JButton("Biceps");
        bicepButton.setPreferredSize(new Dimension(280,30));
        bicepButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(bicepButton);
        bicepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Bicep Add Session");
            }
        });
    }

    // EFFECTS: sets up the tricep exercise button and its behaviour
    private void createTricepButton() {
        tricepButton = new JButton("Triceps");
        tricepButton.setPreferredSize(new Dimension(280,30));
        tricepButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(tricepButton);
        tricepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Triceps Add Session");
            }
        });
    }

    // EFFECTS: sets up the back exercise button and its behaviour
    private void createBackButton() {
        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(280,30));
        backButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Back Add Session");
            }
        });
    }

    // EFFECTS: sets up the chest exercise button and its behaviour
    private void createChestButton() {
        chestButton = new JButton("Chest");
        chestButton.setPreferredSize(new Dimension(280,30));
        chestButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(chestButton);
        chestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Chest Add Session");
            }
        });
    }
}
