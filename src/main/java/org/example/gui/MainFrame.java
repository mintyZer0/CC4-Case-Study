package org.example.gui;
import javax.swing.*;
import org.example.Hospital;
import org.example.gui.panels.AddPatientEnd;
import org.example.gui.panels.OutputPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    Hospital hospital = new Hospital();

    JPanel mainPanel = new JPanel();
    OutputPanel outputPanel = new OutputPanel(hospital);
    AddPatientEnd addPatientEnd = new AddPatientEnd(hospital, outputPanel);
    CardLayout cardLayout = new CardLayout();
    JSplitPane splitPane;


    public MainFrame(String title){
        super();
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);

        mainPanel.setLayout(cardLayout);
        mainPanel.add(addPatientEnd, "addPatientEnd");

        cardLayout.show(mainPanel, "addPatientEnd");


        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainPanel, outputPanel);
        splitPane.setResizeWeight(0.6);
        splitPane.setDividerSize(3);

        this.add(splitPane, BorderLayout.CENTER);

        createMenuBar();



    }
    public void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu add = new JMenu("Add");
        JMenuItem addPatientEnd = new JMenuItem("Add Patient End");
        JMenuItem addCriticalPatient = new JMenuItem("Add Critical Patient");
        JMenuItem addPatientAfter =  new JMenuItem("Add Patient After");
        add.add(addPatientEnd);
        add.add(addCriticalPatient);
        add.add(addPatientAfter);
        menuBar.add(add);

        JMenu remove = new JMenu("Remove");
        JMenuItem removePatient = new JMenuItem("Remove Patient");
        remove.add(removePatient);
        menuBar.add(remove);

        JMenu display = new JMenu("Display");
        JMenuItem displayQueue = new JMenuItem("Display Queue");
        displayQueue.addActionListener(e -> {
          outputPanel.appendText(hospital.getDisplayQueue());
        });
        display.add(displayQueue);
        menuBar.add(display);

        setJMenuBar(menuBar);
    }

}
