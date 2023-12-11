
import javax.swing.*;
import java.awt.*;

public class GUI {

    public GUI() {
        super();

    }

    public String login() {

        String login = JOptionPane.showInputDialog(null,
                "Enter ID to login:",
                "Login",
                JOptionPane.INFORMATION_MESSAGE);
        return login;

    }

    public String getPatientId() {
        String id = JOptionPane.showInputDialog(null,
                "Enter patient ID to Veiw their Shedule",
                "PatientId",
                JOptionPane.INFORMATION_MESSAGE);
        return id;

    }

    public void idError() {
        JOptionPane.showMessageDialog(null, "ID was not found in database. Please try again", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public int DoctorMenu(Doctor doctor) {
        String[] options = { "Make Schedule", "veiw Schedule", "Exit" };
        while (true) {

            int choice = JOptionPane.showOptionDialog(null,
                    "Welcome Dr. " + doctor.getLast_name() + "\n",
                    "Dr. " + doctor.getLast_name() + "'s Login Menu",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == options.length - 1) {
                choice = -1;
            }
            return choice;
        }
    }

    public Schedule inputSchedule(Doctor doctor) {
        JTextField patientId = new JTextField(10);
        JTextField drugId = new JTextField(10);
        JTextField dosage = new JTextField(10);
        JTextField drLastname = new JTextField(10);
        JTextField date = new JTextField(10);
        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Enter Patient ID:"));
        panel.add(patientId);
        panel.add(new JLabel("Enter Drug ID or Name:"));
        panel.add(drugId);
        panel.add(new JLabel("Enter Drug Dosage:"));
        panel.add(dosage);
        panel.add(new JLabel("Enter Dr Last Name:"));
        panel.add(drLastname);
        panel.add(new JLabel("Enter Pickup Date:"));
        panel.add(date);

        int result = JOptionPane.showConfirmDialog(null, panel, "Schedule Maker",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        while (result != JOptionPane.OK_OPTION) {
            if (result == JOptionPane.OK_CANCEL_OPTION) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Oops! Something went wrong. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, panel, "Schedule Maker",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        }

        Schedule s = new Schedule(patientId.getText(),
                drugId.getText(),
                dosage.getText(),
                drLastname.getText(),
                date.getText());
        return s;
    }

    public int NurseMenu(Nurse nurse) {
        // add to options"Veiw patients"
        String[] options = { "Admister drug","Veiw Schedule", "Exit" };
        while (true) {

            int choice = JOptionPane.showOptionDialog(null,
                    "Welcome  " + nurse.getFirst_name() + " " + nurse.getLast_name() + "\n",
                    nurse.getLast_name() + "'s Login Menu",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            System.out.println(choice);
            // chooses the path to go down
            // based on the index in the options list
            if (choice == options.length - 1) {
                choice = -1;
            }
            return choice;
        }
    }

    public void admisterDrug(Schedule s, Nurse nurse) {
        while (true) {
            String barcode = JOptionPane.showInputDialog(null,
                    "Scan the drug barcode",
                    "scan barcode",
                    JOptionPane.INFORMATION_MESSAGE);
            if (barcode.equals(s.getDrug_id())) {
                s.setNurse_last(nurse.getLast_name());

                displaySchedule(s);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "the Barcode Scan failed", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void displaySchedule(Schedule s) {
        JOptionPane.showMessageDialog(null, s.printSchedule(), "Schedule",
                JOptionPane.INFORMATION_MESSAGE);
    }
}