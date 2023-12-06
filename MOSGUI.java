import java.util.*;

import javax.swing.JOptionPane;

public class MOSGUI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		
		Staff Staff1 = new Staff("211", "Thomas", "Hobbes");
		Staff Staff2 = new Staff("245", "Adam", "Smith");
		Staff Staff3 = new Staff("289", "Francis", "Bacon");
		staffList.add(Staff1);
		staffList.add(Staff2);
		staffList.add(Staff3);
		Staff Staff4 = new Staff("120", "David", "Hume");
		Staff Staff5 = new Staff("104", "John", "Locke");
		Staff Staff6 = new Staff("167", "George", "Berkeley");
		staffList.add(Staff4);
		staffList.add(Staff5);
		staffList.add(Staff6);
		//Doctor target = new Doctor("245");


		//JOptionPane.showMessageDialog(null, target.getFirst_name(), "Last Name of Doc", 0);

		
		System.out.println("test1");

		System.out.println("The array list contains: " + staffList);
        System.out.println("Enter a string to search for: ");
        String search = scanner.nextLine();
        for (Staff staff : staffList) {
            if (staff.getId().equals(search)) {
                System.out.println(staff);
				System.out.print(staff instanceof Staff);
            }
        }
	}
	
//	public void Scan(String drug_id) {
//	if(drug_id)
//}
	
}
