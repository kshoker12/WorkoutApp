package ui;

import model.Exercise;
import model.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the view session panel where we can view all exercises
public class ViewSessionPanel extends JPanel {
    private JPanel east;
    private CardLayout eastLayout;
    private Session session;
    private JButton goBackButton;

    // EFFECTS: initializes the view session panel and all its panels
    public ViewSessionPanel(Session session, JPanel east, CardLayout eastLayout) {
        super(new GridLayout(7, 1, 10, 10));
        this.east = east;
        this.eastLayout = eastLayout;
        this.east.add(this, "View Session");
        this.session = session;
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(300, 400));
        initLabels();
        initGoBack(east, eastLayout);
    }

    // EFFECTS: sets up the go back button
    private void initGoBack(JPanel east, CardLayout eastLayout) {
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

    // EFFECTS: sets up the exercises labels
    private void initLabels() {
        for (Exercise e: session.getSessionTracker()) {
            JLabel j = new JLabel(e.getName() + " : " + e.getSets() + " Sets : " + e.getReps() + " Reps");
            add(j);
            j.setFont(new Font("Arial", Font.ITALIC, 16));
            j.setPreferredSize(new Dimension(280, 30));
            j.setBackground(Color.lightGray);
        }
    }


}
