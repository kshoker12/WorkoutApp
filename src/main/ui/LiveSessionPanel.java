package ui;

import model.Exercise;
import model.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the panel which is displayed when session is live
public class LiveSessionPanel extends JPanel {
    private Session session;
    private CardLayout eastLayout;
    private EastPanelManager panelManager;
    private JPanel east;

    // EFFECTS: constructs the panel and the given features of the panel
    public LiveSessionPanel(Session session, CardLayout eastLayout, JPanel east, EastPanelManager p) {
        super(new GridLayout(7, 1, 10, 10));
        this.session = session;
        this.east = east;
        this.eastLayout = eastLayout;
        panelManager = p;
        this.east.add(this, "Live Session");
        JLabel imageLabel = new JLabel();
        ImageIcon image = new ImageIcon("./data/cpsc-210-project-pic1.png");
        imageLabel.setIcon(image);
        imageLabel.setIconTextGap(10);
        this.add(imageLabel);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(300, 400));
        initCurrentExercise();
        initNextExercise();
    }

    // MODIFIES: session
    // EFFECTS: if session.getSessionSize > 0, then update it to the next exercise and if not then display the end
    // session panel
    private void initNextExercise() {
        JButton nextExercise = new JButton("Next Exercise");
        nextExercise.setPreferredSize(new Dimension(280,30));
        nextExercise.setFont(new Font("Arial",Font.BOLD, 20));
        this.add(nextExercise);
        nextExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (session.getSessionSize() > 0) {
                    panelManager.updateLiveSessionPanel();
                    eastLayout.show(east, "Live Session");
                } else {
                    eastLayout.show(east, "End Session");
                }
            }
        });
    }

    // EFFECTS: displays the first exercise in session as a JLabel
    private void initCurrentExercise() {
        if (session.getSessionTracker().size() > 0) {
            Exercise e = session.getExerciseAtIndex(0);
            session.nextExercise();
            JLabel currentExercise =
                    new JLabel(e.getName() + " : " + e.getSets() + " Sets : " + e.getReps() + " Reps");
            add(currentExercise);
            currentExercise.setFont(new Font("Arial", Font.ITALIC, 16));
            currentExercise.setPreferredSize(new Dimension(280, 30));
            currentExercise.setBackground(Color.lightGray);
        }
    }


}
