package ui;

import model.Exercise;
import model.Workout;

import javax.swing.*;
import java.awt.*;

// Represents an abstract class for all the different types of panels for each muscle group such as edit, add, remove
// panels
public abstract class WorkoutsPanel extends JPanel {
    private Workout workout;

    // EFFECTS: Constructs the default panel and sets up exercise labels
    public WorkoutsPanel(Workout w) {
        super(new GridLayout(w.getExercises().size(), 1, 10, 10));
        workout = w;
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        setPreferredSize(new Dimension(300, 400));
        setBackground(Color.white);
        initLabels();

    }

    // EFFECTS: creates all exercise label for muscle group
    private void initLabels() {
        for (Exercise e: workout.getExercises()) {
            JLabel j = new JLabel(e.getName() + " : " + e.getSets() + " Sets : " + e.getReps() + " Reps");
            j.setBackground(Color.cyan);
            j.setFont(new Font("Arial", Font.ITALIC, 16));
            j.setPreferredSize(new Dimension(280, 30));
            j.setBackground(Color.cyan);
            j.setForeground(Color.black);
            add(j);
        }

    }

    //Getter
    public Workout getWorkout() {
        return workout;
    }
}
