package com.example.demo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
@Entity
@Table(name="products")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="plantname")
	private String name;
	private String plantid;
	private String gardentools;
	private double price;
	

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


	public String getPlantid() {
		return plantid;
	}


	public void setPlantid(String plantid) {
		this.plantid = plantid;
	}


	public String getGardentools() {
		return gardentools;
	}


	public void setGardentools(String gardentools) {
		this.gardentools = gardentools;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void updateFrom(Product updatedProduct) {
		// TODO Auto-generated method stub
		
	}
}