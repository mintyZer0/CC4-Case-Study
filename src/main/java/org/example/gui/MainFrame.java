package org.example.gui;
import javax.swing.*;
import org.example.Hospital;
import org.example.gui.panels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main frame of the application
public class MainFrame extends JFrame{
    Hospital hospital = new Hospital();

    // Panels
    JPanel mainPanel = new JPanel();
    OutputPanel outputPanel = new OutputPanel(hospital);
    AddPatientEnd addPatientEnd = new AddPatientEnd(hospital, outputPanel);
    AddCriticalPatient addCriticalPatient = new AddCriticalPatient(hospital, outputPanel);
    AddPatientAfter addPatientAfter= new AddPatientAfter(hospital, outputPanel);
    RemovePatient removePatient = new RemovePatient(hospital, outputPanel);
    CardLayout cardLayout = new CardLayout();
    JSplitPane splitPane;


    public MainFrame(String title){
        super();
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);

        // Set up main panel with card layout
        mainPanel.setLayout(cardLayout);
        mainPanel.add(addPatientEnd, "addPatientEnd");
        mainPanel.add(addCriticalPatient, "addCriticalPatient");
        mainPanel.add(addPatientAfter, "addPatientAfter");
        mainPanel.add(removePatient, "removePatient");

        cardLayout.show(mainPanel, "addPatientEnd");


        // Set up split pane
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainPanel, outputPanel);
        splitPane.setResizeWeight(0.6);
        splitPane.setDividerSize(3);

        this.add(splitPane, BorderLayout.CENTER);

        createMenuBar();



    }

    // Creates the menu bar
    public void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        // Add menu
        JMenu add = new JMenu("Add");
        JMenuItem addPatientEnd = new JMenuItem("Add Patient End");
        JMenuItem addCriticalPatient = new JMenuItem("Add Critical Patient");
        JMenuItem addPatientAfter =  new JMenuItem("Add Patient After");

        // Remove menu
        JMenu remove = new JMenu("Remove");
        JMenuItem removePatient = new JMenuItem("Remove Patient");
        remove.add(removePatient);

        // Display menu
        JMenu display = new JMenu("Display");
        JMenuItem displayQueue = new JMenuItem("Display Queue");
        display.add(displayQueue);

        // Action listeners for menu items
       addPatientEnd.addActionListener(e -> {
           System.out.println("Switching to addPatientEnd");
           setDisplay("addPatientEnd");
       }) ;
       addCriticalPatient.addActionListener(e -> {
           System.out.println("Switching to addCriticalPatient");
           setDisplay("addCriticalPatient");
        }) ;

       addPatientAfter.addActionListener(e -> {
            System.out.println("Switching to AddPatientAfter");
            setDisplay("addPatientAfter");
        }) ;
       removePatient.addActionListener(e -> {
           System.out.println("Switching to removePatient");
           setDisplay("removePatient");
       });

        displayQueue.addActionListener(e -> {
            outputPanel.appendText(hospital.getDisplayQueue());
        });

        // Add menus to menu bar
        add.add(addPatientEnd);
        add.add(addCriticalPatient);
        add.add(addPatientAfter);
        menuBar.add(add);
        menuBar.add(remove);
        menuBar.add(display);
        setJMenuBar(menuBar);
    }

    // Sets the displayed panel
    public void setDisplay(String display){
        cardLayout.show(mainPanel, display);
    }

}
