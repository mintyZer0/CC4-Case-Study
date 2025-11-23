package org.example;

import org.example.gui.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame("Hospital");
            frame.setVisible(true);
        });
    }
}