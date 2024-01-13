package com.tobeto.business;

import com.tobeto.core.logging.ILogger;
import com.tobeto.dataAccess.IDao;
import com.tobeto.entities.Course;
import com.tobeto.entities.Instructor;

import java.util.List;

public class CourseManager {
    private IDao iDao;
    private List<ILogger> iLogger;
    public CourseManager(IDao iDao, List<ILogger> iLogger) {
        this.iDao = iDao;
        this.iLogger = iLogger;
    }

    public void add(Course course) throws Exception{
        if (CourseValidator.isvalid(course)){
            System.out.println("==========================================================================");
            System.out.println(course.getName() + " veritabanına eklendi");
            iDao.add(course);
            for (ILogger logger : iLogger){
                logger.log(course.getName());
            }
            System.out.println("==========================================================================");
        }else {
            throw new Exception("Bilgiler geçersiz!");
        }
    }

    public void assignInstructorToCourse(Course course, Instructor instructors){
        //Instructor instructor = new Instructor();
        //Collections.addAll(instructor, instructors);
        course.setInstructor(instructors);
    }
}
