package Lap4;

public class OrderItem {
	private Product p;
	private int quality;

	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return p + ", quality = " + quality + "\n";
	}

	public Product getProduct() {
		return p;
	}

	public double getQuality() {
		return quality;
	}
}
