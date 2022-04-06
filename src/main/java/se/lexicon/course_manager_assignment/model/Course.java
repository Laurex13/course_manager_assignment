package se.lexicon.course_manager_assignment.model;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class Course {
    private int courseId;
    String courseName;
    LocalDate startDate;
    int weekDuration;
    Collection<Student>students = new HashSet<>();

    public Course(int courseId, String courseName, LocalDate startDate, int weekDuration, Collection<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public Course() {}

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
    public boolean enrollStudent(Student student){
        return students.add(student);
    }
    public boolean unenrollStudent(Student student){
        return students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return courseId == course.courseId && weekDuration == course.weekDuration && courseName.equals(course.courseName) && startDate.equals(course.startDate) && students.equals(course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
