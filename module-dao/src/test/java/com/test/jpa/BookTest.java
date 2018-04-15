package com.test.jpa;

import org.junit.Test;

import com.test.jpa.enums.CategoryTitle;

public class BookTest extends BaseTest{

	public BookTest() {
		super("play.jpa");
	}
	
	
	@Test
	public void testFindBookById(){
		beginTransaction();
		
		Category category = new Category();
		category.setParent_Category(0);
		category.setCategory(CategoryTitle.TECHNICAL);
		category.setDescription("Technical Category");
		entityManager().persist(category);
		commit();
	}
	

}
