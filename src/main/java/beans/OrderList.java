package beans;

public class OrderList {
	
	int pId;
	String pName,pQuantity,pBrand;
	float cost;
	String cusName,cusPhone,cusLocation;
	
	
	public OrderList() {
		
	}


	public OrderList(int pId, float cost, String pName, String pQuantity,
			String pBrand, String cusName, String cusPhone,
			String cusLocation) 
		{
					this.pId = pId;
					this.cost = cost;
					this.pName = pName;
					this.pQuantity = pQuantity;
					this.pBrand = pBrand;
					this.cusName = cusName;
					this.cusPhone = cusPhone;
					this.cusLocation = cusLocation;
		}


	public final int getpId() {
		return pId;
	}


	public final void setpId(int pId) {
		this.pId = pId;
	}


	public final float getCost() {
		return cost;
	}


	public final void setCost(float cost) {
		this.cost = cost;
	}


	public final String getpName() {
		return pName;
	}


	public final void setpName(String pName) {
		this.pName = pName;
	}


	public final String getpQuantity() {
		return pQuantity;
	}


	public final void setpQuantity(String pQuantity) {
		this.pQuantity = pQuantity;
	}


	public final String getpBrand() {
		return pBrand;
	}


	public final void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}


	


	public final String getCusName() {
		return cusName;
	}


	public final void setCusName(String cusName) {
		this.cusName = cusName;
	}


	public final String getCusPhone() {
		return cusPhone;
	}


	public final void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}


	public final String getCusLocation() {
		return cusLocation;
	}


	public final void setCusLocation(String cusLocation) {
		this.cusLocation = cusLocation;
	}
	
	
	
	
	
	
}

