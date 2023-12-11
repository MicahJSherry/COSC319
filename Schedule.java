package RefactoredCode;

public class Schedule {
	private String patient_id;
	private String doc_last_name;
	private String nurse_last_name;
	private String dosage;
	private String drug_id;
	private String pickup_date;
	private String status = "Not Administered";

	public Schedule(String patient_id, String drug_id, String dosage, String doc_last, String pickup_date) {
		super();
		this.patient_id = patient_id;
		this.doc_last_name = doc_last;
		this.dosage = dosage;
		this.drug_id = drug_id;
		this.pickup_date = pickup_date;
	}

	public void setNurse_last(String nurse_last) {

		this.nurse_last_name = nurse_last;
		changeStatus();

	}

	public String getPatient_id() {
		return patient_id;
	}

	public String getDoc_last() {
		return doc_last_name;
	}

	public String getNurse_last() {
		return nurse_last_name;
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

	public String getStatus() {
		return status;
	}

	public void changeStatus() {
		this.status = "administered";
	}

	public String printSchedule() {
		String schedule;
		if (status.equals("Not Administered")) {
			schedule = "\nPatient ID: " + patient_id +
					"\n\nDrug ID: " + drug_id +
					"\n\nDosage: " + dosage +
					"\n\nPrescribed by Dr. " + doc_last_name +
					"\n\nStatus: " + status +
					"\n\nPickup date: " + pickup_date +
					"\n";

		} else {
			schedule = "\nPatient ID: " + patient_id +
					"\n\nDrug ID: " + drug_id +
					"\n\nDosage: " + dosage +
					"\n\nPrescribed by Dr. " + doc_last_name +
					"\n\nStatus: " + status +
					"\n\nAdministered by " + nurse_last_name +
					"\n\nPickup date: " + pickup_date +
					"\n";
		}
		return schedule;
	}
}