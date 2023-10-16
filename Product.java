package Lap4;

public class Product {
	private String id;
	private String name;
	private double price;
	private String type;

	public Product(String id, String name, double price, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "id = " + id + ", name = " + name + ", price = " + price + ", type = " + type;
	}

	public int compareTo(Product p) {
		int byName = this.getName().compareTo(p.getName());
		if (byName == 0) {
			return Double.compare(this.getPrice(), p.getPrice());
		}
		return byName;
	}
}
