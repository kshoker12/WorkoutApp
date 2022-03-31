package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the panel which is displayed when the session ends
public class EndSessionPanel extends JPanel {

    // EFFECTS: initializes the panel
    public EndSessionPanel() {
        super(new GridLayout(1, 1, 10, 10));
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        setPreferredSize(new Dimension(300, 400));
        setBackground(Color.white);
        initImage();
        initQuitSession();
    }

    // EFFECTS: initializes the image for the panel
    private void initImage() {
        ImageIcon image = new ImageIcon("./data/cpsc-210-project-pic2.png");
        JLabel imagePanel = new JLabel();
        imagePanel.setIcon(image);
        imagePanel.setIconTextGap(10);
        this.add(imagePanel);
    }

    // EFFECTS: initializes the quit session button and the behaviour
    private void initQuitSession() {
        JButton quitSession = new JButton("Quit Session");
        quitSession.setPreferredSize(new Dimension(280,30));
        quitSession.setFont(new Font("Arial",Font.BOLD, 20));
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
