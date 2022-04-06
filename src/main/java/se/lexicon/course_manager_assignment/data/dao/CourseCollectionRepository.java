package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;

    public CourseCollectionRepository(Collection<Course> courses) { this.courses = courses;

    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        int courseId = CourseSequencer.nextCourseId();
        courses.add((Course) courses);
    return createCourse(" ",startDate,weekDuration);
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (id == course.getCourseId()) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        List<Course> courseNameContains = new ArrayList<>();
        for (Course course: courses){
            if(course.getCourseName() == name){
                courseNameContains.add(course);
            }
        }
        return courseNameContains;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {

        List<Course> courseDateBefore = new ArrayList<>();
        for (Course course: courses){
            if(course.getStartDate() == end){
                courseDateBefore.add(course);
            }
        }
        return courseDateBefore;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {

        List<Course> courseDateAfter = new ArrayList<>();
        for (Course course: courses){
            if(course.getStartDate() == start){
                courseDateAfter.add(course);
            }
        }
        return courseDateAfter;
    }

    @Override
    public Collection<Course> findAll() {
        List<Course> allCourses = new ArrayList<>();
        allCourses.addAll(courses);

        return allCourses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        Collection<Course> coursesFoundByStudentId = new HashSet<>();
        for (Course course : courses){
            for (Student student : course.getStudents()){
                if(student.getStudentId() == studentId) {
                    coursesFoundByStudentId.add(course);
                }
            }
        }
        return coursesFoundByStudentId;
    }

    @Override
    public boolean removeCourse(Course course) {
       return courses.remove(course);
        }

    @Override
    public void clear() {
        this.courses = new HashSet<>();

    }
}
