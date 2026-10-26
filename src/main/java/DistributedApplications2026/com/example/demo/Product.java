package DistributedApplications2026.com.example.demo;

import java.math.BigDecimal;

public class Product {

	private int id;
	private String name;
	private BigDecimal price;
	private String size;
	private String color;

	public Product() {
	}

	public Product(int id, String name, BigDecimal price, String size, String color) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.size = size;
		this.color = color;
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
