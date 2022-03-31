package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the main menu to navigate through key features which is a panel taking up the west side of the JFrame
public class MainMenuPanel extends JPanel {
    private final JPanel east;
    private final CardLayout eastLayout;

    // EFFECTS: Constructs the Panel and all the necessary buttons
    public MainMenuPanel(JPanel east, CardLayout eastLayout) {
        super(new GridLayout(5, 1, 10, 10));
        this.east = east;
        this.eastLayout = eastLayout;
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        setBackground(Color.black);
        setPreferredSize(new Dimension(300, 500));
        createMuscleGroupButton();
        createEditSessionButton();
        createViewSessionButton();
        createStartSessionButton();
        createQuitSessionButton();
    }

    // EFFECTS: Creates muscle group button
    private void createMuscleGroupButton() {
        JButton muscleGroupButton = new JButton("Create + Edit Exercise");
        muscleGroupButton.setPreferredSize(new Dimension(280,40));
        muscleGroupButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(muscleGroupButton);
        muscleGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Muscle Menu");
            }
        });
    }

    // EFFECTS: creates edit session button
    private void createEditSessionButton() {
        JButton editSession = new JButton("Edit Session");
        editSession.setPreferredSize(new Dimension(280,40));
        editSession.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(editSession);
        editSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Session Menu");
            }
        });
    }

    // EFFECTS: creates view session button
    private void createViewSessionButton() {
        JButton viewSession = new JButton("View Session");
        viewSession.setPreferredSize(new Dimension(280,40));
        viewSession.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(viewSession);
        viewSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "View Session");
            }
        });
    }

    // EFFECTS: creates start session button
    private void createStartSessionButton() {
        JButton startSession = new JButton("Start Session");
        startSession.setPreferredSize(new Dimension(280,40));
        startSession.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(startSession);
        startSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eastLayout.show(east, "Live Session");
            }
        });
    }

    // EFFECTS: Creates Quit Session Button
    private void createQuitSessionButton() {
        JButton quitSession = new JButton("Quit Session");
        quitSession.setPreferredSize(new Dimension(280,40));
        quitSession.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(quitSession);
        quitSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Event next: EventLog.getInstance()) {
                    System.out.println(next.toString() + "\n\n");
                }
                System.exit(0);
            }
        });
    }
}
