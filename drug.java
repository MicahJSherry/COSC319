
public class drug {
	private String barcode;
	private String name;
	private String color;
	
	public drug(String barcode, String name, String color) {

		super();
		this.barcode = barcode;
		this.name = name;
		this.color = color;
	}
	
	public drug(String barcode) {
		super();
		this.barcode = barcode;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}
	@Override
    public String toString() {
        return "drug{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

