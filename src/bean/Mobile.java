package bean;

public class Mobile {
	int id;
	String name;
	double price;
	int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Donor Details \n");
		sb.append("Mobile Id: " +id +"\n");
		sb.append("Mobile Name: "+name +"\n");
		sb.append("Mobile Price: "+ price +"\n");
		sb.append("Mobile quantity: "+ quantity +"\n");
		return sb.toString();
	}
}
