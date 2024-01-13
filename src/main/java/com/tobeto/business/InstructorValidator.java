package com.tobeto.business;

import com.tobeto.entities.Instructor;

import java.util.HashSet;
import java.util.Set;

public class InstructorValidator {
    private static Set<String> uniqueInstructorNames = new HashSet<>();

    public static boolean inValid(Instructor instructor){
        if (!uniqueInstructorNames.contains(instructor.getFullName())){
            uniqueInstructorNames.add(instructor.getFullName());
            return true;
        }else {
            return false;
        }
    }
}
