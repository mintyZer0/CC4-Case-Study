package org.example.gui.panels;

import org.example.Hospital;
import org.example.gui.panels.OutputPanel;

import javax.swing.*;
import java.awt.*;

public class AddPatientEnd extends JPanel {
    String[] conditions = {"Normal", "Urgent", "Critical"};
    Hospital hospital;

    public AddPatientEnd(Hospital hospital, OutputPanel outputPanel) {
        this.setLayout(new BorderLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();

        JPanel wrapperPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        JPanel fieldsPanel = new JPanel();

        JLabel titleLabel = new JLabel("Input ID");
        JLabel nameLabel = new JLabel("Input Name");
        JLabel conditionLabel = new JLabel("Select Condition");

        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);

        JComboBox comboBox = new JComboBox(conditions);
        JButton addButton = new JButton("Add");

        addButton.addActionListener(e ->{
            String id = idField.getText();
            String name = nameField.getText();
            String condition = comboBox.getSelectedItem().toString();
            System.out.println(id + " " + name + " " + condition);
            if((id != null && !id.isEmpty()) && (name != null && !name.isEmpty()) && (condition != null && !condition.isEmpty())) {
                hospital.AddPatientEnd(id, name, condition);
                String output = ("Adding Patient: " + id + " " + name + " " + condition);
                outputPanel.appendText(output);
            }else {
                JOptionPane.showMessageDialog(AddPatientEnd.this, ("Please fill all the fields\n" + "Must be a non-empty string"));
            }
        });

        wrapperPanel.setLayout(new BorderLayout());
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200));
        wrapperPanel.add(containerPanel,BorderLayout.CENTER);

        containerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        fieldsPanel.setLayout(new GridBagLayout());

        // set label on first column
        gridBagLayout.gridx=0;
        gridBagLayout.gridy=0;
        gridBagLayout.insets = new Insets(10,10,10,10);
        fieldsPanel.add(titleLabel, gridBagLayout);
        gridBagLayout.gridx=0;
        gridBagLayout.gridy=1;
        fieldsPanel.add(nameLabel, gridBagLayout);
        gridBagLayout.gridx=0;
        gridBagLayout.gridy=2;
        fieldsPanel.add(conditionLabel, gridBagLayout);

        // set fields on second column
        gridBagLayout.gridx=1;
        gridBagLayout.gridy=0;
        fieldsPanel.add(idField, gridBagLayout);
        gridBagLayout.gridx=1;
        gridBagLayout.gridy=1;
        fieldsPanel.add(nameField, gridBagLayout);
        gridBagLayout.gridx=1;
        gridBagLayout.gridy=2;
        fieldsPanel.add(comboBox, gridBagLayout);
        gridBagLayout.gridx=3;
        gridBagLayout.gridy=4;
        fieldsPanel.add(addButton, gridBagLayout);

        containerPanel.add(fieldsPanel);




        this.add(wrapperPanel, BorderLayout.CENTER);
    }

}
