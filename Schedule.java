import java.util.ArrayList;

public class Schedule {
	private String patient_id;
	private String doc_id;
	private String nurse_id;
	private String dosage;
	private String drug_id;
	private String pickup_date;
	private Boolean status;
	
	public Schedule(String patient_id, String doc_id, String nurse_id, String dosage, String drug_id,
			String pickup_date, Boolean status) {
		super();
		this.patient_id = patient_id;
		this.doc_id = doc_id;
		this.nurse_id = nurse_id;
		this.dosage = dosage;
		this.drug_id = drug_id;
		this.pickup_date = pickup_date;
		this.status = status;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public String getNurse_id() {
		return nurse_id;
	}

	public String getDosage() {
		return dosage;
	}

	public String getDrug_id() {
		return drug_id;
	}

	public String getPickup_date() {
		return pickup_date;
	}

	public Boolean getStatus() {
		return status;
	}
	
	public String printSchedule(ArrayList<Doctor> doctors, ArrayList<Nurse> nurses) {
		Doctor prescriber = new Doctor(doc_id);
		int doc_index = doctors.indexOf(prescriber);
		
		Nurse administer = new Nurse(nurse_id);
		int nurse_index = nurses.indexOf(administer);
		
		String doc_last_name = doctors.get(doc_index).getLast_name();
		String nurse_name = nurses.get(nurse_index).getFirst_name() + " " + nurses.get(nurse_index).getLast_name();
		
		String schedule = "\nPatient ID: " + patient_id +
				"\nDrug ID: " + drug_id + 
				"\nDosage: " + dosage + 
				"\nPrescribed by Dr. " + doc_last_name + 
				"\nAdministered by " + nurse_name + 
				"\nPickup date: " + pickup_date +
				"\nPicked up: " + status + "\n";
		return schedule;
	}
}
