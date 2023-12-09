import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MOSGUI
{
	@SuppressWarnings("resource")
	
	// info labels
	private static JLabel patientLabel;
	private static JLabel barcodeLabel;
	// entry fields
	private static JTextField patientText;
	private static JTextField barcodeText;
	// buttons
	private static JButton pButton;
	private static JButton bButton;
	// patient and barcode info
	private static JLabel patientLog;
	private static JLabel barcodeLog;
	// patient id
	private static String patientID;
	// barcode
	private static String barcode;

	public static void main(String[] args) throws FileNotFoundException 
	{
		// frame
		JFrame frame = new JFrame();
		frame.setSize(4000, 5000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// panel
		JPanel panel2 = new JPanel();
		frame.add(panel2);
		panel2.setLayout(null);
		
		

		
		//staff list
		ArrayList<Staff> staff = new ArrayList<Staff>();

		// Nurses
		Staff Staff1 = new Staff("211", "Thomas", "Hobbes");
		Staff Staff2 = new Staff("245", "Adam", "Smith");
		Staff Staff3 = new Staff("289", "Francis", "Bacon");

		// Doctors
		Staff Staff4 = new Staff("120", "David", "Hume");
		Staff Staff5 = new Staff("104", "John", "Locke");
		Staff Staff6 = new Staff("167", "George", "Berkeley");

		staff.add(Staff1);
		staff.add(Staff2);
		staff.add(Staff3);
		staff.add(Staff4);
		staff.add(Staff5);
		staff.add(Staff6);

		//Schedule schedule_x = null; //blank schedule
		ArrayList<Schedule> schedule = new ArrayList<Schedule>();

		String login = JOptionPane.showInputDialog(null, "Enter ID to login:\n\nType \"quit\" to quit", "Login",
				JOptionPane.INFORMATION_MESSAGE);
		Staff target = new Staff(login);
		while (!login.contentEquals("quit"))
		{
			int check_index = staff.indexOf(target);
			String ID = staff.get(check_index).getId();
			char doc_num = '1';
			char nurse_num = '2';
			
			if (check_index < 0) 
			{ // ID not found
				JOptionPane.showMessageDialog(null, "ID was not found in database. Please try again", "Error",
						JOptionPane.ERROR_MESSAGE);
				login = JOptionPane.showInputDialog(null, "Enter ID to login:\n\nType \"quit\" to quit", "Login",
						JOptionPane.INFORMATION_MESSAGE);
				target = new Staff(login);
				continue;
			}
			

			// Doctor Login
			if (ID.charAt(0) == doc_num) 
			{
				String[] options = { "Make Schedule", "Exit" };
				int choice = JOptionPane.showOptionDialog(null,
						"Welcome Dr. " + staff.get(check_index).getLast_name() + "\n",
						"Dr. " + staff.get(check_index).getLast_name() + "'s Login Menu",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (choice == JOptionPane.YES_OPTION) 
				{
					JTextField field1 = new JTextField(10);
					JTextField field2 = new JTextField(10);
					JTextField field3 = new JTextField(10);
					JTextField field4 = new JTextField(10);
					JTextField field5 = new JTextField(10);
					JTextField field6 = new JTextField(10);
					JTextField field7 = new JTextField(10);
					JPanel panel = new JPanel(new GridLayout(0, 1));
					panel.add(new JLabel("Enter Patient ID:"));
					panel.add(field1);
					panel.add(new JLabel("Enter Drug ID or Name:"));
					panel.add(field2);
					panel.add(new JLabel("Enter Drug Dosage:"));
					panel.add(field3);
					panel.add(new JLabel("Enter Dr Last Name:"));
					panel.add(field4);
					panel.add(new JLabel("Enter Nurse Last Name:"));
					panel.add(field5);
					panel.add(new JLabel("Enter Pickup Date:"));
					panel.add(field6);


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
					String p_id = field1.getText();
					String drug_id = field2.getText();
					String dosage = field3.getText();
					String dr_last = field4.getText();
					String nurse_last = field5.getText();
					String pickup_d = field6.getText();
					String pickup_s = field7.getText();
					
					
					Schedule schedule_x =new Schedule(p_id, drug_id, dosage, dr_last, nurse_last, pickup_d);
					JOptionPane.showMessageDialog(null, schedule_x.printSchedule(), "Schedule", JOptionPane.INFORMATION_MESSAGE);
					schedule.add(schedule_x); //schedule is an arraylist of patients, can print using tostring if needed
					
					if ((ID.charAt(0) == doc_num) && (!p_id.equals("")))
					{
				        PrintStream writeDoctorNotes = new PrintStream(new FileOutputStream("DoctorInput.txt",true));
						writeDoctorNotes.append("Patient ID:" + p_id + " Drug Id:" + drug_id + " Dosage:" + dosage + 
						" Doctor Lastname:" + dr_last + " Nurse Lastname:" + nurse_last + " Pick Up Time:" + pickup_d + "\n");

					}
				}
				else if (choice == JOptionPane.NO_OPTION) 
				{
					login = JOptionPane.showInputDialog(null, "Enter ID to login:\n\nType \"quit\" to quit", "Login",
							JOptionPane.INFORMATION_MESSAGE);
					target = new Staff(login);
					continue;
				} // END OF DOC LOGIN
				System.out.println (schedule.toString());
				// Nurse Login
			}
			else if (ID.charAt(0) == nurse_num) 
			{
				String[] options = { "Enter Patient ID", "Exit" };
				int choice = JOptionPane.showOptionDialog(null,
						"Welcome Nurse " + staff.get(check_index).getLast_name() + "\n",
						"Nurse. " + staff.get(check_index).getLast_name() + "'s Login Menu",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (choice == JOptionPane.YES_OPTION) 
				{
					//frame.setVisible(true);
					JTextField field1 = new JTextField(10);
					JPanel panel = new JPanel(new GridLayout(0, 1));
					panel.add(new JLabel("Enter Patient ID:"));
					panel.add(field1);
					
					 int result = JOptionPane.showConfirmDialog(null, panel, "Identify Patient",
				                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				        while(result != JOptionPane.OK_OPTION) {
				        	if(result == JOptionPane.OK_CANCEL_OPTION) {
				        		break;
				        	}
					        JOptionPane.showMessageDialog(null, "Oops! Something went wrong. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				        	result = JOptionPane.showConfirmDialog(null, panel, "Schedule Maker",
					                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				        }
				        String p_id = field1.getText();
				        if(!p_id.equals(""))
				        {
				 
				        	if(p_id.equals("1")) //need to add...search to find matching patient id from schedule arraylist
					        {
					        	JTextField codefield1 = new JTextField(10);
								JPanel codepanel = new JPanel(new GridLayout(0, 1));
								codepanel.add(new JLabel("Enter barcode:"));
								codepanel.add(codefield1);
								
					        	int result2 = JOptionPane.showConfirmDialog(null, codepanel, "patient info",
										JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
								while (result2 != JOptionPane.OK_OPTION) {
									if (result2 == JOptionPane.OK_CANCEL_OPTION) {
										break;
									}
									JOptionPane.showMessageDialog(null, "Oops! Something went wrong. Please try again.", "Error",
											JOptionPane.ERROR_MESSAGE);
									result2 = JOptionPane.showConfirmDialog(null, codepanel, "patient info",
											JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
								}
								String barcode = codefield1.getText();
					        }
				        }
				        
				}
				else if (choice == JOptionPane.NO_OPTION)
				{
					login = JOptionPane.showInputDialog(null, "Enter ID to login:\n\nType \"quit\" to quit", "Login",
							JOptionPane.INFORMATION_MESSAGE);
					target = new Staff(login);
					continue;
				}
				
				
			} // END OF NURSE LOGIN
			
			

		} // END OF INITIAL LOGIN
		


		
	}

}
