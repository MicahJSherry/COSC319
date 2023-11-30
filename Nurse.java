
public class Nurse {
	private String id;
	private String first_name;
	private String last_name;
	
	public Nurse(String id, String first_name, String last_name) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Nurse(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}
	
	
	
}
