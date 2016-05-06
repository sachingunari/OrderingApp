package com.ordering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	
	

	public Item() {
		super();
	}
	
	public Item(int id, String name, int category_Id, int cooking_Time, int cost, String pic_Url, int calories) {
		super();
		Id = id;
		this.name = name;
		this.category_Id = category_Id;
		this.cooking_Time = cooking_Time;
		this.cost = cost;
		this.pic_Url = pic_Url;
		this.calories = calories;
	}


	@Id
	@Column
	private int Id;
	
	@Column
	private String name;
	
	@Column
	private int category_Id;
	
	@Column
	private int cooking_Time;
	
	@Column
	private int cost;
	
	@Column
	private String pic_Url;
	
	@Column
	private int calories;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public int getCooking_Time() {
		return cooking_Time;
	}

	public void setCooking_Time(int cooking_Time) {
		this.cooking_Time = cooking_Time;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getPic_Url() {
		return pic_Url;
	}

	public void setPic_Url(String pic_Url) {
		this.pic_Url = pic_Url;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	

}
