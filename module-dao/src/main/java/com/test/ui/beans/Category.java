package com.test.ui.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Category {
	
	@NotNull(message = "error.id.notnull")
	@Min(value = 3,message="error.id.min")
	private Integer id;
	@NotNull(message = "error.category.notnull")
    @Size(min=10, max=50,message="error.category.size")
	private String category;
	@NotNull(message = "error.desc.notnull")
    @Size(min=10, max=50,message="error.desc.size")
	private String description;
	@NotNull(message = "error.parentcategory.notnull")
	@Min(value = 3,message="error.parentcategory.min")
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
