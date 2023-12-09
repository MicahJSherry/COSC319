package RefactoredCode;

public class Staff {
	private String id;
	private String first_name;
	private String last_name;

	public Staff(String id, String first_name, String last_name) {

		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Staff(String id) {
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

	@Override
	public String toString() {
		return "Staff{" +
				"id='" + id + '\'' +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Staff other = (Staff) obj;
		return id.equals(other.id); // Compare based on ID
	}
}
