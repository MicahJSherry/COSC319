package RefactoredCode;

import java.util.ArrayList;

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

        int choice;
        ArrayList<Schedule> schedules = new ArrayList<>();
        int index = -1;
        while (true) {

            while (index < 0) {
                String id = test.login();
                if (id == null) {
                    return;
                }
                index = findStaff(staff, id);
                if (index < 0) {
                    test.displayLoginError();
                }
            }

            Staff s = staff.get(index);
            if (s instanceof Doctor) {
                while (true) {
                    choice = test.DoctorMenu((Doctor) s);
                    System.out.println(choice);
                    if (choice == -1) {
                        break;
                    }
                    switch (choice) {
                        case 0:
                            Schedule schedule = test.inputSchedule((Doctor) s);
                            test.displaySchedule(schedule);
                            schedules.add(schedule);
                            break;
                        case 1:
                            String id = test.getPatientId();
                            index = findShedule(schedules, id);
                            test.displaySchedule(schedules.get(index));
                            break;
                    }
                }

            } else {
                test.NurseMenu((Nurse) s);

            }
        }
    }

    public static int findStaff(ArrayList<Staff> staff, String id) {

        for (int i = 0; i < staff.size(); i++) {
            Staff s = staff.get(i);
            if (s.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static int findShedule(ArrayList<Schedule> schedules, String id) {

        for (int i = 0; i < schedules.size(); i++) {
            Schedule s = schedules.get(i);
            if (s.getPatient_id().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
