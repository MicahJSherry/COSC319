package RefactoredCode;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        GUI test = new GUI();

        ArrayList<Staff> staff = new ArrayList<Staff>();

        // Nurses
        Staff Staff1 = new Nurse("211", "Thomas", "Hobbes");
        Staff Staff2 = new Nurse("245", "Adam", "Smith");
        Staff Staff3 = new Nurse("289", "Francis", "Bacon");
        // Doctors
        Staff Staff4 = new Doctor("120", "David", "Hume");
        Staff Staff5 = new Doctor("104", "John", "Locke");
        Staff Staff6 = new Doctor("167", "George", "Berkeley");
        staff.add(Staff1);
        staff.add(Staff2);
        staff.add(Staff3);
        staff.add(Staff4);
        staff.add(Staff5);
        staff.add(Staff6);

        // Populate drug database
        Drug drug;
        ArrayList<Drug> drugList = new ArrayList<>();
        drug = new Drug("312", "Oxycodone", "Red");
        drugList.add(drug);
        drug = new Drug("345", "Adderall", "Blue");
        drugList.add(drug);
        drug = new Drug("378", "Aspirin", "Green");
        drugList.add(drug);

        while (true) {
            int indexOfStaff = -1;
            while (indexOfStaff < 0) {
                String id = test.login();
                if (id == null) {
                    return;
                }
                indexOfStaff = findIndex(staff, id);
                if (indexOfStaff < 0) {
                    test.displayLoginError();
                }
            }
            Staff s = staff.get(indexOfStaff);
            if (s instanceof Doctor) {
                test.DoctorMenu((Doctor) s);
            } else {
                test.NurseMenu((Nurse) s);
            }
        }
    }

    public static int findIndex(ArrayList<Staff> staff, String id) {

        for (int i = 0; i < staff.size(); i++) {
            Staff s = staff.get(i);
            if (s.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
