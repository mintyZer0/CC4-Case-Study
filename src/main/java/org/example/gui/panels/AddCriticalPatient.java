package org.example.gui.panels;

import org.example.Hospital;

import javax.swing.*;
import java.awt.*;

// Panel for adding a critical patient
public class AddCriticalPatient extends JPanel {
    String[] conditions = {"Normal", "Urgent", "Critical"};
    Hospital hospital;

    public AddCriticalPatient(Hospital hospital, OutputPanel outputPanel) {
        this.hospital = hospital;
        this.setLayout(new GridBagLayout());

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Labels
        JLabel operationLabel = new JLabel("Add Critical Patient");
        JLabel titleLabel = new JLabel("Input ID");
        JLabel nameLabel = new JLabel("Input Name");
        JLabel conditionLabel = new JLabel("Select Condition");

        // Text fields
        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);

        // Combo box for condition
        JComboBox comboBox = new JComboBox(conditions);
        comboBox.setSelectedItem(conditions[2]);
        comboBox.disable();

        // Add button
        JButton addButton = new JButton("Add");

        // Action listener for the add button
        addButton.addActionListener(e ->{
            String id = idField.getText();
            String name = nameField.getText();
            String condition = comboBox.getSelectedItem().toString();

            // Check for empty fields
            if((id != null && !id.isEmpty()) && (name != null && !name.isEmpty())) {
                if(!hospital.patientExists(id)){
                    hospital.AddCriticalPatient(id, name);
                    String output = ("Adding Patient: " + id + " " + name + " " + condition);
                    outputPanel.appendText(output);
                }else{
                    JOptionPane.showMessageDialog(null, "Patient ID already exists");
                }
            }else {
                JOptionPane.showMessageDialog(AddCriticalPatient.this, ("Please fill all the fields\n" + "Must be a non-empty string"));
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
        gbc.gridy=2;
        fieldsPanel.add(nameLabel, gbc);
        gbc.gridy=3;
        fieldsPanel.add(conditionLabel, gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        fieldsPanel.add(idField, gbc);
        gbc.gridy=2;
        fieldsPanel.add(nameField, gbc);
        gbc.gridy=3;
        fieldsPanel.add(comboBox, gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(addButton, gbc);

        this.add(fieldsPanel);
    }

}