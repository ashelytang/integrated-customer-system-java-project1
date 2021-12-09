package projectGUI;

import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class IntCustSysMenu {
    private final JButton selectButton = new JButton("Submit");
    private final JPanel menuPanel = new JPanel();
    private final JRadioButton createProfileRadioButton = new JRadioButton("Create Profile");
    private final JRadioButton deleteProfileRadioButton = new JRadioButton("Delete Profile");
    private final JRadioButton updateProfileRadioButton = new JRadioButton("Update Profile");
    private final JRadioButton findDisplayProfileRadioButton = new JRadioButton("Find Profile");
    private final JRadioButton displayAllProfilesRadioButton = new JRadioButton("Display All Profiles");
    ButtonGroup buttons = new ButtonGroup();


    public IntCustSysMenu() {

        selectButton.addActionListener(e -> {

            int check = 0;

            if (createProfileRadioButton.isSelected()) {
                CreateProfile v = new CreateProfile();
                check = 1;
                v.openGUI();
            }
            if (deleteProfileRadioButton.isSelected()) {
                DeleteProfile prof = new DeleteProfile();
                check = 1;
                prof.openGUI();
            }

            if (updateProfileRadioButton.isSelected()) {
                UpdateProfile prof = new UpdateProfile();
                check = 1;
                prof.openGUI();
            }

            if (findDisplayProfileRadioButton.isSelected()) {
                DispProfile1 prof = new DispProfile1();
                check = 1;
                prof.openGUI();
            }
            if (displayAllProfilesRadioButton.isSelected()) {
                MultLogin prof = new MultLogin();
                check = 1;
                prof.openGUI();
            }
            if (check == 0){
                JOptionPane.showMessageDialog(null, "Please Choose a Valid Option");
            }
        });
    }
    //public static void main(String[] args) {}

    public void openGUI() {
        buttons.add(createProfileRadioButton);
        buttons.add(deleteProfileRadioButton);
        buttons.add(updateProfileRadioButton);
        buttons.add(findDisplayProfileRadioButton);
        buttons.add(displayAllProfilesRadioButton);


        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new IntCustSysMenu().menuPanel);
        f.add(createProfileRadioButton);
        f.add(deleteProfileRadioButton);
        f.add(updateProfileRadioButton);
        f.add(findDisplayProfileRadioButton);
        f.add(displayAllProfilesRadioButton);
        f.add(selectButton);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setSize(200, 400);
    }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Path:\n");
            String strpath = in.nextLine();
            Path path = Paths.get(strpath);
    }
}
