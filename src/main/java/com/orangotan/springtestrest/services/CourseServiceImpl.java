package com.orangotan.springtestrest.services;

import com.orangotan.springtestrest.dao.CourseDao;
import com.orangotan.springtestrest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

//    List<Course> list;

    public CourseServiceImpl(){
//        list = new ArrayList<>();
//        //dummy data
//        list.add(new Course(145,"Java For Beginners","This course is for beginners"));
//        list.add(new Course(349,"Python for Beginners","This is a masterclass for Python 3"));

    }

    //implements the method of interface CourseService to reduce dependency
    @Override
    public List<Course> getCourses() {
        //return list to the controller
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//        Course c = null;
//        for(Course course:list){
//            if(course.getId()==courseId)
//                c = course;break;
//        }
        Course toFetch = courseDao.getReferenceById(courseId);
        return courseDao.getReferenceById(toFetch.getId());
    }

    @Override
    public Course addCourse(Course course){
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
//        int len = list.size();
//        int count = 0;
//        for(Course course1: list){
//            if(course1.getId()==course.getId()){
//                course1.setTitle(course.getTitle());
//                course1.setId(course.getId());
//                course1.setDescription(course.getDescription());
//                break;
//            }
//            count++;
//            if(count == len){
//                System.out.println("No such entry as courseId:"+course.getId());
//            }
//        }
        courseDao.save(course);
        return course;
    }

    @Override
    public Course deleteCourse(long courseId) {
//        int len = list.size();
//        int count = 0;
//        for(Course course:list){
//            if(course.getId()==courseId){
//                list.remove(course);return course;
//            }
//            count++;
//            if(count==len){
//                System.out.println("No such Course as courseId:"+course.getId());break;
//            }
//        }
        Course entityToDelete = courseDao.getReferenceById(courseId);
        courseDao.delete(entityToDelete);
        return null;
    }
}
