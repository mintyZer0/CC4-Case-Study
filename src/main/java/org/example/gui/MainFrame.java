package org.example.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import org.example.Hospital;
import org.example.gui.panels.AddCriticalPatient;
import org.example.gui.panels.AddPatientAfter;
import org.example.gui.panels.AddPatientEnd;
import org.example.gui.panels.OutputPanel;
import org.example.gui.panels.RemovePatient;

// Main frame of the application
public class MainFrame extends JFrame {

  Hospital hospital = new Hospital();

  // Panels
  JPanel mainPanel = new JPanel();
  OutputPanel outputPanel = new OutputPanel(hospital);
  AddPatientEnd addPatientEnd = new AddPatientEnd(hospital, outputPanel);
  AddCriticalPatient addCriticalPatient = new AddCriticalPatient(
    hospital,
    outputPanel
  );
  AddPatientAfter addPatientAfter = new AddPatientAfter(hospital, outputPanel);
  RemovePatient removePatient = new RemovePatient(hospital, outputPanel);
  CardLayout cardLayout = new CardLayout();
  JSplitPane splitPane;

  public MainFrame(String title) {
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
    splitPane = new JSplitPane(
      JSplitPane.VERTICAL_SPLIT,
      mainPanel,
      outputPanel
    );
    splitPane.setResizeWeight(0.6);
    splitPane.setDividerSize(3);

    this.add(splitPane, BorderLayout.CENTER);

    createMenuBar();
  }

  // Creates the menu bar
  public final void createMenuBar() {
    JMenuBar menuBar = new JMenuBar();

    // Add menu
    JMenu add = new JMenu("Add");
    JMenuItem addPatientEndMenu = new JMenuItem("Add Patient End");
    JMenuItem addCriticalPatientMenu = new JMenuItem("Add Critical Patient");
    JMenuItem addPatientAfterMenu = new JMenuItem("Add Patient After");

    // Remove menu
    JMenu remove = new JMenu("Remove");
    JMenuItem removePatientMenu = new JMenuItem("Remove Patient");
    remove.add(removePatientMenu);

    // Display menu
    JMenu display = new JMenu("Display");
    JMenuItem displayQueue = new JMenuItem("Display Queue");
    JMenuItem clearTerminal = new JMenuItem("Clear");
    display.add(displayQueue);
    display.add(clearTerminal);

    // Action listeners for menu items
    addPatientEndMenu.addActionListener(e -> {
      System.out.println("Switching to addPatientEnd");
      setDisplay("addPatientEnd");
    });
    addCriticalPatientMenu.addActionListener(e -> {
      System.out.println("Switching to addCriticalPatient");
      setDisplay("addCriticalPatient");
    });

    addPatientAfterMenu.addActionListener(e -> {
      System.out.println("Switching to AddPatientAfter");
      setDisplay("addPatientAfter");
    });
    removePatientMenu.addActionListener(e -> {
      System.out.println("Switching to removePatient");
      setDisplay("removePatient");
    });

    displayQueue.addActionListener(e -> {
      outputPanel.appendText(hospital.DisplayQueue());
    });
    clearTerminal.addActionListener(e -> {
      outputPanel.clearTerminal();
    });

    // Add menus to menu bar
    add.add(addPatientEndMenu);
    add.add(addCriticalPatientMenu);
    add.add(addPatientAfterMenu);
    menuBar.add(add);
    menuBar.add(remove);
    menuBar.add(display);
    setJMenuBar(menuBar);
  }

  // Sets the displayed panel
  public void setDisplay(String display) {
    cardLayout.show(mainPanel, display);
  }
}
