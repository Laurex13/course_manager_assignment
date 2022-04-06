package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        int studentId = StudentSequencer.nextStudentId();
        Student student = new Student(studentId,name,email,address);
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for (Student student: students){
            if (student.getEmail().toLowerCase(Locale.ROOT).contains(email.trim().toLowerCase(Locale.ROOT)))
               return student;
            }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> studentNameContains = new ArrayList<Student>();
        for (Student student: students) {
            if (student.getName().equalsIgnoreCase(name)) {
                studentNameContains.add(student);
            }
        }
        return studentNameContains;
    }

    @Override
    public  Student findById(int id) {
        Student searchStudents = new Student(0, "", "", "");
        for (Student student: students) {
            if(student.getStudentId() == id){
                searchStudents.setStudentId(student.getStudentId());
                searchStudents.setName(student.getName());
                searchStudents.setAddress(student.getAddress());
                searchStudents.setEmail(student.getEmail());
            }

        }

        return searchStudents;
    }

    @Override
    public Collection<Student> findAll() {
        HashSet<Student> allStudents = new HashSet<>();
        allStudents.addAll(students);

        return allStudents;
    }

    @Override
    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
