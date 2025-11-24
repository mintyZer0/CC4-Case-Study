package org.example.gui.panels;

import org.example.Hospital;

import javax.swing.*;
import java.awt.*;

// Panel for removing a patient
public class RemovePatient extends JPanel {
    String[] conditions = {"Normal", "Urgent", "Critical"};
    Hospital hospital;

    public RemovePatient(Hospital hospital, OutputPanel outputPanel) {
        this.hospital = hospital;
        this.setLayout(new GridBagLayout());

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Labels
        JLabel operationLabel = new JLabel("Remove Patient");
        JLabel titleLabel = new JLabel("Input ID");

        // Text fields
        JTextField idField = new JTextField(15);

        // Remove button
        JButton addButton = new JButton("Remove");

        // Action listener for the remove button
        addButton.addActionListener(e ->{
            String id = idField.getText();

            // Check for empty fields
            if((id != null && !id.isEmpty())) {
                // Check if patient exists
                if (hospital.patientExists(id)){
                    hospital.RemovePatient(id);
                    String output = ("Removing Patient with ID: " + id);
                    outputPanel.appendText(output);
                }else{
                    JOptionPane.showMessageDialog(null, "Patient does not exist");
                }
            }else {
                JOptionPane.showMessageDialog(RemovePatient.this, ("Please fill all the fields\n" + "Must be a non-empty string"));
            }
        });

        operationLabel.setFont(new Font("Dialog", Font.BOLD, 20));

        gbc.insets = new Insets(10,10,10,10);

        // Add components to the panel
        // Change grid width to center operation label
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(operationLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx=0;
        gbc.gridy=1;
        fieldsPanel.add(titleLabel, gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        fieldsPanel.add(idField, gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(addButton, gbc);

        this.add(fieldsPanel);
    }
}