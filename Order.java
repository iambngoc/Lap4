package Lap4;

import java.util.Arrays;

public class Order {
	private OrderItem[] items;
	private ComparatorC sort;

	public Order(OrderItem[] items) {
		this.items = items;
	}

	public double cost() {
		double sum = 0.0;
		for (int i = 0; i < items.length; i++) {
			sum += items[i].getProduct().getPrice();
		}
		return sum;
	}

	public boolean resursionBinarySearch(Product p, int low, int high) {
		if (low > high) {
			return false;
		} else {
			int mid = (low + high) / 2;
			if (p == items[mid].getProduct()) {
				return true;
			} else if (p.compareTo(items[mid].getProduct()) < 0) {
				return resursionBinarySearch(p, low, mid - 1);
			} else {
				return resursionBinarySearch(p, mid + 1, high);
			}
		}
	}

	public boolean contains(Product p) {
		Arrays.sort(items, new ComparatorC());
		return resursionBinarySearch(p, 0, items.length);
	}

	public Product[] filter(String type) {
		int size = 0;
		for (int i = 0; i < items.length; i++) {
			if (type.compareTo(items[i].getProduct().getType()) == 0) {
				size++;
			}
		}
		Product[] res = new Product[size];
		for (int i = 0; i < items.length; i++) {
			int temp = type.compareTo(items[i].getProduct().getType());
			if (temp == 0) {
				res[(res.length) - size] = items[i].getProduct();
				size--;
			}
		}
		return res;
	}
	public static void sortItem(OrderItem[] item) {
		for (int i = 1; i < item.length; i++) {
			OrderItem temp = item[i];
			int j = i - 1;
			while (j >= 0 && item[j].getProduct().getPrice() > temp.getProduct().getPrice()) {
				item[j + 1] = item[j];
				j--;
			}
			item[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		Product pd1 = new Product("1", "chicken", 25.0, "food");
		Product pd2 = new Product("5", "sausage", 150.5, "food");
		Product pd3 = new Product("3", "coca", 15.0, "drink");
		Product pd4 = new Product("4", "rice", 50.0, "food");

		OrderItem oi1 = new OrderItem(pd1, 8);
		OrderItem oi2 = new OrderItem(pd2, 10);
		OrderItem oi3 = new OrderItem(pd3, 9);
		OrderItem oi4 = new OrderItem(pd4, 7);

		OrderItem[] test = { oi2, oi1, oi4, oi3};

		Order oder = new Order(test);

//		System.out.println(Arrays.toString(test));
//		System.out.println(oder.cost());
//		System.out.println(oder.contains(pd4));
//		System.out.println(Arrays.toString(oder.filter("food")));
		sortItem(test);
		System.out.println(Arrays.toString(test));
	}
}
