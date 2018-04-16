package com.test.ui.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Category {
	
	@NotNull
	@Min(3)
	private int id;
	@NotNull
    @Size(min=10, max=50)
	private String category;
	@NotNull
    @Size(min=10, max=60)
	private String description;
	@NotNull
	@Min(3)
	private int parent_Category;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParent_Category() {
		return parent_Category;
	}
	public void setParent_Category(int parent_Category) {
		this.parent_Category = parent_Category;
	}
}
