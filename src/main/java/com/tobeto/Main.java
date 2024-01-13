package com.tobeto;

import com.tobeto.business.CategoryManager;
import com.tobeto.business.CourseManager;
import com.tobeto.business.InstructorManager;
import com.tobeto.core.logging.DatabaseLogger;
import com.tobeto.core.logging.FileLogger;
import com.tobeto.core.logging.ILogger;
import com.tobeto.core.logging.MailLogger;
import com.tobeto.dataAccess.HibernateDao;
import com.tobeto.dataAccess.JdbcDao;
import com.tobeto.entities.Category;
import com.tobeto.entities.Course;
import com.tobeto.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{

        List<ILogger> loggers = new ArrayList<>();
        loggers.add(new DatabaseLogger());
        loggers.add(new FileLogger());
        loggers.add(new MailLogger());

        // Category nesnesi oluşturuldu
        Category category = new Category(1,"Programlama");
        // Category nesneleri veritabanına eklendi
        CategoryManager categoryManager = new CategoryManager(new HibernateDao(), loggers);
        categoryManager.add(category);


        // Course nesneleri oluşturuldu
        Course course1 = new Course(
                1,
                "Yazılım Geliştirici Yetiştirme Kampı (JavaScript)",
                "1,5 ay sürecek Yazılım Geliştirici Yetiştirme Kampımızın takip döküman ve duyurularını buradan yapacağız.",
                "img1jpg",
                0
        );
        Course course2 = new Course(
                2,
                "(2023) Yazılım Geliştirici Yetiştirme Kampı (Python & Selenium)",
                "Python & Selenium Yazılım Geliştirici Yetiştirme Kampımızın takip döküman ve duyurularını buradan yapacağız.",
                "img2jpg",
                0
        );
        Course course3 = new Course(
                3,
                "(2022) Yazılım Geliştirici Yetiştirme Kampı (JAVA)",
                "Java Yazılım Geliştirici Yetiştirme Kampımızın takip döküman ve duyurularını buradan yapacağız.",
                "img3.jpg",
                0
        );
        Course course4 = new Course(
                4,
                "Yazılım Geliştirici Yetiştirme Kampı (C# + ANGULAR)",
                "2 ay sürecek Yazılım Geliştirici Yetiştirme Kampımızın takip döküman ve duyurularını buradan yapacağız.",
                "img4.jpg",
                0
        );
        Course course5 = new Course(
                5,
                "Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)",
                "2 ay sürecek Yazılım Geliştirici Yetiştirme Kampımızın takip döküman ve duyurularını buradan yapacağız.",
                "img5.jpg",
                0
        );
        Course course6 = new Course(
                6,
                "Senior Yazılım Geliştirici Yetiştirme Kampı (.NET)",
                "Senior Yazılım Geliştirici Yetiştirme Kampımızın takip döküman ve duyurularını buradan yapacağız.",
                "img6.jpg",
                0
        );
        Course course7 = new Course(
                7,
                "Programlamaya Giriş İçin Temel Kurs",
                "PYTHON JAVA C# gibi programlama dilleri için temel programlama mantığını anlaşılır örneklerle öğrenin.",
                "img7.jpg",
                0
        );
        // Course nesneleri veritabanına eklendi
        CourseManager courseManager = new CourseManager(new JdbcDao(), loggers);
        courseManager.add(course1);
        courseManager.add(course2);
        courseManager.add(course3);
        courseManager.add(course4);
        courseManager.add(course5);
        courseManager.add(course6);
        courseManager.add(course7);

        // Instructor nesneleri oluşturuldu
        Instructor instructor1 = new Instructor(1,"Engin Demiroğ");
        Instructor instructor2 = new Instructor(2,"Halit Enes Kalaycı");
        // Instructor nesneleri veritabanına eklendi
        InstructorManager instructorManager = new InstructorManager(new JdbcDao(), loggers);
        instructorManager.add(instructor1);
        instructorManager.add(instructor2);



        // Category nesnesine Course nesneleri atandı
        categoryManager.assignCourseToCategory(category, course1,course2);

        // Course nesnelerine Instructor atandı
        courseManager.assignInstructorToCourse(course1, instructor1);
        courseManager.assignInstructorToCourse(course2, instructor2);

        // Instructor nesnelerine Course atandı
        instructorManager.assignCourseToInstructor(instructor1, course1);


    }
}