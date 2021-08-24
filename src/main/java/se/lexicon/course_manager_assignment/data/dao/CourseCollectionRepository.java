package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class CourseCollectionRepository implements CourseDao{

   // private static List<Course> courses = new ArrayList<>();

    boolean isCourseRemoved = false;


    private Collection<Course> courses;

    public CourseCollectionRepository(Collection<Course> courses) {

    }


    // public CourseCollectionRepository(Collection<Course> courses) {
     //   this.courses = courses;
   // }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {

        courses.add((Course) courses);
    return createCourse(" ",startDate,weekDuration);
    }

    @Override
    public Course findById(int id) {
        Course searchCourse = null;
        for (Course course : courses){
            if(course.getId() == id){
                searchCourse = course;
                break;
            }
        }
        return searchCourse;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        List<Course> searchCourse = new ArrayList<>();
        for (Course course: courses){
            if(course.getCourseName() == name){
                searchCourse.add(course);
            }
        }
        return searchCourse;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {

        List<Course> searchCourse = new ArrayList<>();
        for (Course course: courses){
            if(course.getStartDate() == end){
                searchCourse.add(course);
            }
        }
        return searchCourse;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {

        List<Course> searchCourse = new ArrayList<>();
        for (Course course: courses){
            if(course.getStartDate() == start){
                searchCourse.add(course);
            }
        }
        return searchCourse;
    }

    @Override
    public Collection<Course> findAll() {

        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {

        Course searchCourse = null;
        for (Course course : courses){
            if(course.getId() == studentId){
                searchCourse = course;
                break;
            }
        }
        return findByStudentId(studentId);
    }

    @Override
    public boolean removeCourse(Course course) {

        isCourseRemoved = false;
        if(courses.contains(course)){
            courses.remove(course);
            isCourseRemoved = true;
        }
        return isCourseRemoved;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();

    }
}
