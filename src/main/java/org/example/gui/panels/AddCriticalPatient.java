package org.example.gui.panels;

import org.example.Hospital;

import javax.swing.*;
import java.awt.*;

public class AddCriticalPatient extends JPanel {
    String[] conditions = {"Normal", "Urgent", "Critical"};
    Hospital hospital;

    public AddCriticalPatient(Hospital hospital, OutputPanel outputPanel) {
        this.hospital = hospital;
        this.setLayout(new GridBagLayout());

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel operationLabel = new JLabel("Add Critical Patient");
        JLabel titleLabel = new JLabel("Input ID");
        JLabel nameLabel = new JLabel("Input Name");
        JLabel conditionLabel = new JLabel("Select Condition");

        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);

        JComboBox comboBox = new JComboBox(conditions);
        comboBox.setSelectedItem(conditions[2]);
        comboBox.disable();

        JButton addButton = new JButton("Add");

        addButton.addActionListener(e ->{
            String id = idField.getText();
            String name = nameField.getText();
            String condition = comboBox.getSelectedItem().toString();

            if((id != null && !id.isEmpty()) && (name != null && !name.isEmpty())) {
                hospital.AddCriticalPatient(id, name);
                String output = ("Adding Patient: " + id + " " + name + " " + condition);
                outputPanel.appendText(output);
            }else {
                JOptionPane.showMessageDialog(AddCriticalPatient.this, ("Please fill all the fields\n" + "Must be a non-empty string"));
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