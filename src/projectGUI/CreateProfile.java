package projectGUI;
import CustomerProf.CustomerProf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class CreateProfile {  
    //this block of code is for creating the textboxes 
    private JPanel createPanel = new JPanel();
    private JTextField admin = new JTextField(10);
    private JTextField firstName = new JTextField(10);
    private JTextField lastName = new JTextField(10);
    private JTextField address = new JTextField(10);
    private JTextField phone = new JTextField(10);
    private JTextField income = new JTextField(10);
    private JComboBox comboBox1 = new JComboBox(); // Use
    private JComboBox comboBox2 = new JComboBox();// Status
    private JTextField model = new JTextField(10);
    private JTextField year = new JTextField(10);
    private JComboBox comboBox3 = new JComboBox();; //Type
    private JComboBox comboBox4 = new JComboBox();; //Method
    private JButton submitButton = new JButton("Submit");

    public CreateProfile() {
//        CustomerProf cp = new CustomerProf();
        //Adding the options to the Use drop down menu
        comboBox1.setSize(120, 2);
        comboBox1.addItem("Business");
        comboBox1.addItem("Personal");
        comboBox1.addItem("Both");

        //Adding the options to the Status drop down menu
        comboBox2.setSize(120, 2);
        comboBox2.addItem("Active");
        comboBox2.addItem("Inactive");

        //Adding the options to the Type drop down menu
        comboBox3.setSize(120, 2);
        comboBox3.addItem("Sudan");
        comboBox3.addItem("Hatchback");
        comboBox3.addItem("Luxury");
        comboBox3.addItem("Sport");
        comboBox3.addItem("Other");

        //Adding the options to the Method drop down menu
        comboBox4.setSize(120, 2);
        comboBox4.addItem("New");
        comboBox4.addItem("Certified Pre-Owned");
        comboBox4.addItem("Used");
        comboBox4.addItem("Other");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List userProf = buildProf();
                DBController prof = new DBController();
                getPath pathname = new getPath();
                Path path = pathname.getIt();
                prof.addProfile(userProf, path);
                JOptionPane.showMessageDialog(null, "Success!");
            }
        });
    }
    public void openGUI () {  //will be used for opening up a gui window for this class
        JFrame f = new JFrame("Integrated Customer System"); //creates an instance
        f.setContentPane(new CreateProfile().createPanel);
        f.add(new JLabel("Admin ID:", SwingConstants.LEFT), f);
        f.add(admin);
        f.add(new JLabel("First Name:", SwingConstants.LEFT), f);
        f.add(firstName);
        f.add(new JLabel("Last Name:", SwingConstants.LEFT), f);
        f.add(lastName);
        f.add(new JLabel("Address:", SwingConstants.LEFT), f);
        f.add(address);
        f.add(new JLabel("Phone:", SwingConstants.LEFT), f);
        f.add(phone);
        f.add(new JLabel("Income:", SwingConstants.LEFT), f);
        f.add(income);
        f.add(new JLabel("Use:", SwingConstants.LEFT), f);
        f.add(comboBox1);
        f.add(new JLabel("Status:", SwingConstants.LEFT), f);
        f.add(comboBox2);
        f.add(new JLabel("Model:", SwingConstants.LEFT), f);
        f.add(model);
        f.add(new JLabel("Year:", SwingConstants.LEFT), f);
        f.add(year);
        f.add(new JLabel("Type:", SwingConstants.LEFT), f);
        f.add(comboBox3);
        f.add(new JLabel("Method:", SwingConstants.LEFT), f);
        f.add(comboBox4);
        f.add(submitButton);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true); //show the actual frame
        f.setSize(200,400);
    }
    public List<String> buildProf() {
        //Gets all the User Inputs from the boxes
        String id = admin.getText();
        String first = firstName.getText();
        String last = lastName.getText();
        String address1 = address.getText();
        String phone1 = phone.getText();
        String income1 = income.getText();
        String use = (String) comboBox1.getSelectedItem();
        String status = (String) comboBox2.getSelectedItem();
        String model1 = model.getText();
        String year1 = year.getText();
        String type = (String) comboBox3.getSelectedItem();
        String method = (String) comboBox4.getSelectedItem();

        //Puts the new user into a user Profile List
        List<String> profile = new ArrayList<>();
        profile.add(id);
        profile.add(first);
        profile.add(last);
        profile.add(address1);
        profile.add(phone1);
        profile.add(income1);
        profile.add(use);
        profile.add(status);
        profile.add(model1);
        profile.add(year1);
        profile.add(type);
        profile.add(method);

        return profile;
    }

}
