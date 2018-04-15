package com.test.jpa.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.test.jpa.enums.CategoryTitle;

@Converter(autoApply = true)
public class CategoryTitleConverter implements AttributeConverter<CategoryTitle, String> {

	@Override
	public String convertToDatabaseColumn(CategoryTitle ct) {
		return ct.getTitle();
	}

	@Override
	public CategoryTitle convertToEntityAttribute(String title) {
		return CategoryTitle.from(title);
	}

	
	 
}
