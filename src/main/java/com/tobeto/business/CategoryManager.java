package com.tobeto.business;

import com.tobeto.core.logging.ILogger;
import com.tobeto.dataAccess.IDao;
import com.tobeto.entities.Category;
import com.tobeto.entities.Course;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CategoryManager {
    private IDao iDao;
    private List<ILogger> iLogger;
    public CategoryManager(IDao iDao, List<ILogger> iLogger) {
        this.iDao = iDao;
        this.iLogger = iLogger;
    }
    public void add(Category category) throws Exception{
        if (CategoryValidator.isvalid(category)){
            System.out.println("===========================================================");
            System.out.println(category.getName() + " kategorisi veritabanına eklendi");
            iDao.add(category);
            for (ILogger logger : iLogger){
                logger.log(category.getName());
            }
            System.out.println("===========================================================");
        }else {
            throw new Exception("Category adı aynı olamaz");
        }
    }

    public void assignCourseToCategory(Category category, Course... courses){
        List<Course> courseList = new ArrayList<>();
        Collections.addAll(courseList, courses);
        category.setCourseList(courseList);
    }
}
