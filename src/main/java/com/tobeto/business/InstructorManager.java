package com.tobeto.business;

import com.tobeto.core.logging.ILogger;
import com.tobeto.dataAccess.IDao;
import com.tobeto.entities.Course;
import com.tobeto.entities.Instructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InstructorManager {
    private IDao iDao;
    private List<ILogger> iLogger;
    public InstructorManager(IDao iDao, List<ILogger> iLogger){
        this.iDao = iDao;
        this.iLogger = iLogger;
    }

    public void add(Instructor instructor) throws Exception{
        if (InstructorValidator.inValid(instructor)){
            System.out.println("==========================================================================");
            System.out.println(instructor.getFullName() + " instructor olarak veritabanına eklendi");
            iDao.add(instructor);
            for (ILogger logger : iLogger){
                logger.log(instructor.getFullName());
            }
            System.out.println("==========================================================================");
        }else {
            throw new Exception("Aynı isim mevcut");
        }
    }

    public void assignCourseToInstructor(Instructor instructor, Course... courses){
        List<Course> courseList = new ArrayList<>();
        Collections.addAll(courseList, courses);
        instructor.setCourseList(courseList);
    }
}
