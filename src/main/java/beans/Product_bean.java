package beans;

public class Product_bean {
	int id;
	String name,quantity,brand,available,fileName;
	float cost;
	
	public Product_bean() {
		
	}
	
	public Product_bean(int id,String name,String quantity,String brand,String available,float cost,String fileName) {
		this.id=id;
		this.name=name;
		this.quantity=quantity;
		this.brand=brand;
		this.cost=cost;
		this.fileName=fileName;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
