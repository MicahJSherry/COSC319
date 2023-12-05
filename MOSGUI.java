import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MOSGUI {
	public static void main(String[] args) {

		ArrayList<Staff> Staffs = new ArrayList<Staff>();
		
		Staff Staff1 = new Staff("211", "Thomas", "Hobbes");
		Staff Staff2 = new Staff("245", "Adam", "Smith");
		Staff Staff3 = new Staff("289", "Francis", "Bacon");
		
		Nurse nurse1 = new Nurse("120", "David", "Hume");
		Nurse nurse2 = new Nurse("104", "John", "Locke");
		Nurse nurse3 = new Nurse("167", "George", "Berkeley");

		//Doctor target = new Doctor("245");


		//JOptionPane.showMessageDialog(null, target.getFirst_name(), "Last Name of Doc", 0);

		Staff Staff4 = new Staff("120", "David", "Hume");
		Staff Staff5 = new Staff("104", "John", "Locke");
		Staff Staff6 = new Staff("167", "George", "Berkeley");
		
	}
	
//	public void Scan(String drug_id) {
//	if(drug_id)
//}
	
}
