package com.spring.daos.store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.jpa.enums.CategoryTitle;
import com.test.ui.beans.Category;

@Repository
public class BookStoreDao {
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional(readOnly =true)
	public Category findCategory( int category ) {
		
		com.test.jpa.Category cat = em.find(com.test.jpa.Category.class, category);
		
		if(cat == null) {
			throw new DataAccessException("No data found") {
				private static final long serialVersionUID = 1L;
				
			};
		}
		
		Category cate = new Category();
		cate.setCategory(cat.getCategory().getTitle());
		cate.setId(cat.getId());
		cate.setParent_Category(cat.getParent_Category());
		cate.setDescription(cat.getDescription());
		
		return cate;	
	}
	

	@Transactional
	public Category createCategory(Category category) {
		com.test.jpa.Category cat = new com.test.jpa.Category();
		cat.setParent_Category(category.getId());
		cat.setCategory(CategoryTitle.TECHNICAL);
		cat.setDescription(category.getDescription());
		cat.setParent_Category(category.getParent_Category());
		em.persist(cat);
		
		return category;
	}

}
