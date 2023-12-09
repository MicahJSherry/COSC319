
public class patient extends Schedule
{

	private String patient_id;
	private String doc_id;
	private String nurse_id;
	private String dosage;
	private String drug_id;
	private String pickup_date;
	private String status;

	public patient(String patient_id, String doc_id, String nurse_id, String dosage, String drug_id, String pickup_date,
			String status) 
	{
		super(patient_id, doc_id, nurse_id, dosage, drug_id, pickup_date);
		this.patient_id = patient_id;
		this.doc_id = doc_id;
		this.nurse_id = nurse_id;
		this.dosage = dosage;
		this.drug_id = drug_id;
		this.pickup_date = pickup_date;
		this.status = status;
	}
	
	public String setDrug_id(String drug_id) 
	{
		this.drug_id = drug_id;
		String setDrug_Id = null;
		return setDrug_Id;
	}


	

}
