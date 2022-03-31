package ui;

import model.Event;
import model.EventLog;
import model.Routine;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents the JMenuBar where we save and load routines
public class File extends JMenuBar {
    private static final String JSON_STORE = "./data/workouts.json";
    private Routine routine;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JMenu menu;
    private EastPanelManager panelManager;

    // EFFECTS: sets up the panel and all the menu items
    public File(Routine routine, EastPanelManager panelManager) {
        super();
        this.panelManager = panelManager;
        menu = new JMenu("File");
        menu.setPreferredSize(new Dimension(60, 30));
        menu.setFont(new Font("Arial", Font.BOLD, 20));
        menu.setBackground(Color.DARK_GRAY);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.add(menu);
        this.routine = routine;
        initSave();
        initLoad();
    }

    // EFFECTS: initializes the load menu item and its behaviour
    private void initLoad() {
        JMenuItem load = new JMenuItem("Load");
        load.setPreferredSize(new Dimension(50, 20));
        load.setFont(new Font("Arial", Font.BOLD, 16));
        load.setMargin(new Insets(10, 10, 10, 10));
        menu.add(load);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.setRoutine(loadRoutine());
                panelManager.repaintPanels();
                EventLog.getInstance().logEvent(new Event("Loaded " + routine.getName() + " from "
                        + JSON_STORE));
            }
        });
    }

    // MODIFIES: routine
    // EFFECTS: loads routine
    private Routine loadRoutine() {
        Routine rout = null;
        try {
            rout = jsonReader.read();
            System.out.println("Loaded " + routine.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
        return rout;
    }

    // EFFECTS: initializes the load menu item and its behaviour
    private void initSave() {
        JMenuItem save = new JMenuItem("Save");
        save.setPreferredSize(new Dimension(50, 20));
        save.setFont(new Font("Arial", Font.BOLD, 16));
        save.setMargin(new Insets(10, 10, 10, 10));
        menu.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveRoutine();
                EventLog.getInstance().logEvent(new Event("Saved " + routine.getName() + " to " + JSON_STORE));
            }
        });
    }

    // EFFECTS: saves current routine
    private void saveRoutine() {
        try {
            jsonWriter.open();
            jsonWriter.write(routine);
            jsonWriter.close();
            System.out.println("Saved " + routine.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
}
