package org.example.gui.panels;
import org.example.Hospital;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    Hospital hospital;
    OutputPanel outputPanel;
    JTextArea textArea;

    public OutputPanel(Hospital hospital) {
        this.setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        textArea.setOpaque(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        this.add(scrollPane, BorderLayout.CENTER);
    }
    public void appendText(String text) {
        textArea.append(text+ "\n");
        textArea.getText();
    }
}
