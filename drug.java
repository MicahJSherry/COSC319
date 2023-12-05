public class drug {
	private String name;
	private String barcode;
	private String color;
	
	public drug(String name, String barcode, String color) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.color = color;
	}
	
	public drug(String name) {
		super();
		this.name = name;
	}

	public String getname() {
		return name;
	}

	public String getbarcode() {
		return barcode;
	}

	public String getcolor() {
		return color;
	}
	
}

