package ui;

import javax.swing.*;

// Represents the main method which creates an instance of the WorkoutPlannerApp and also initializes graphical
// interface
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                WorkoutWindow main = new WorkoutWindow();
                main.setVisible(true);
            }
        });
        new WorkoutPlannerApp();
    }
}
