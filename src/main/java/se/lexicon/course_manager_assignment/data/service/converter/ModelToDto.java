package se.lexicon.course_manager_assignment.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {

        return new StudentView(student.getStudentId(),student.getName(),student.getEmail(),student.getAddress());
    }

    @Override
    public CourseView courseToCourseView(Course course) {
        List<StudentView> allStudentView = new ArrayList<>();
        for (Student student : course.getStudents()){
            allStudentView.add(studentToStudentView(student));
        }
        return new CourseView(course.getCourseId(), course.getCourseName(), course.getStartDate(),course.getWeekDuration(),allStudentView);
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        List<CourseView> allCourseViews = new ArrayList<>();
        for (Course course : courses){
            allCourseViews.add(courseToCourseView(course));
        }
        return allCourseViews;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        List<StudentView> allStudentViews = new ArrayList<>();
        for (Student student : students){
            allStudentViews.add(studentToStudentView(student));
        }
        return allStudentViews;

    }
}
