package com.tobeto.business;

import com.tobeto.entities.Course;
import java.util.HashSet;
import java.util.Set;

public class CourseValidator {
    private static Set<String> uniqueCourseNames = new HashSet<>();
    public static boolean isvalid(Course course){
        if (course.getUnitPrice() >= 0 && !uniqueCourseNames.contains(course.getName())){
            uniqueCourseNames.add(course.getName());
            return true;
        }else {
            return false;
        }
    }
}
