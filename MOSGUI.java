import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MOSGUI {
	public static void main(String[] args) {

		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		ArrayList<Nurse> nurses = new ArrayList<Nurse>();
		
		Doctor doc1 = new Doctor("211", "Thomas", "Hobbes");
		Doctor doc2 = new Doctor("245", "Adam", "Smith");
		Doctor doc3 = new Doctor("289", "Francis", "Bacon");
		
		Nurse nurse1 = new Nurse("120", "David", "Hume");
		Nurse nurse2 = new Nurse("104", "John", "Locke");
		Nurse nurse3 = new Nurse("167", "George", "Berkeley");

		//Doctor target = new Doctor("245");


		//JOptionPane.showMessageDialog(null, target.getFirst_name(), "Last Name of Doc", 0);

	}
	
//	public void Scan(String drug_id) {
//	if(drug_id)
//}
	
}
