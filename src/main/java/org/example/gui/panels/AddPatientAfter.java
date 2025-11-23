package org.example.gui.panels;

import org.example.Hospital;

import javax.swing.*;
import java.awt.*;

public class AddPatientAfter extends JPanel {
    String[] conditions = {"Normal", "Urgent", "Critical"};
    Hospital hospital;

    public AddPatientAfter(Hospital hospital, OutputPanel outputPanel) {
        this.hospital = hospital;
        this.setLayout(new GridBagLayout());

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel operationLabel = new JLabel("Add Patient After Existing");
        JLabel existingIdLabel = new JLabel("Existing Patient ID:");
        JLabel titleLabel = new JLabel("New Patient ID:");
        JLabel nameLabel = new JLabel("New Patient Name:");
        JLabel conditionLabel = new JLabel("New Patient Condition:");

        JTextField existingIdField = new JTextField(15);
        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);

        JComboBox comboBox = new JComboBox(conditions);
        JButton addButton = new JButton("Add");

        addButton.addActionListener(e ->{
            String existingId = existingIdField.getText();
            String id = idField.getText();
            String name = nameField.getText();
            String condition = comboBox.getSelectedItem().toString();

            if((existingId != null && !existingId.isEmpty()) && (id != null && !id.isEmpty()) && (name != null && !name.isEmpty()) && (condition != null && !condition.isEmpty())) {
                hospital.AddPatientAfter(existingId, id, name, condition);
                String output = ("Adding Patient: " + id + " " + name + " after " + existingId);
                outputPanel.appendText(output);
            }else {
                JOptionPane.showMessageDialog(AddPatientAfter.this, ("Please fill all the fields\n" + "All fields must be a non-empty string"));
            }
        });

        operationLabel.setFont(new Font("Dialog", Font.BOLD, 20));

        gbc.insets = new Insets(10,10,10,10);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(operationLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx=0;
        gbc.gridy=1;
        fieldsPanel.add(existingIdLabel, gbc);
        gbc.gridy=2;
        fieldsPanel.add(titleLabel, gbc);
        gbc.gridy=3;
        fieldsPanel.add(nameLabel, gbc);
        gbc.gridy=4;
        fieldsPanel.add(conditionLabel, gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        fieldsPanel.add(existingIdField, gbc);
        gbc.gridy=2;
        fieldsPanel.add(idField, gbc);
        gbc.gridy=3;
        fieldsPanel.add(nameField, gbc);
        gbc.gridy=4;
        fieldsPanel.add(comboBox, gbc);

        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(addButton, gbc);

        this.add(fieldsPanel);
    }
}