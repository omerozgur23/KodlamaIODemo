package com.tobeto.business;

import com.tobeto.entities.Category;
import com.tobeto.entities.Course;

import java.util.HashSet;
import java.util.Set;

public class CategoryValidator {
    private static Set<String> uniqueCategoryNames = new HashSet<>();

    public static boolean isvalid(Category category){
        if (!uniqueCategoryNames.contains(category.getName())){
            uniqueCategoryNames.add(category.getName());
            return true;
        }else {
            return false;
        }
    }
}
