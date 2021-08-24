package se.lexicon.course_manager_assignment.model;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class Course {
    int id;
    String courseName;
    LocalDate startDate;
    int weekDuration;
    Collection<Student>students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration, Collection students) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        List<Student> allStudents =new ArrayList<Student>();
        Scanner in = new Scanner(System.in);
        return true;
    }
    public boolean unEnrollStudent(Student student){
        Set<String> remove = new HashSet<>();
        return getStudents().removeIf(Predicate.isEqual(student));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && courseName.equals(course.courseName) && startDate.equals(course.startDate) && students.equals(course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
