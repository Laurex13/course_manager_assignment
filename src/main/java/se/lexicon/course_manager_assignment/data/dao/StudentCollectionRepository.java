package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;
    private Student student;
    boolean isStudentRemoved = false;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        student = new Student(StudentSequencer.nextStudentId());
        student.setName(name);
        student.setEmail(email);
        student.setAddress(address);
        student.setId(student.getId());


        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        Student _nStudent = new Student();
        for (Student nStudent: students){
            if (nStudent.getEmail().equalsIgnoreCase(email)){
                _nStudent = nStudent;
            }
        }
        return student;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> studentCol = new ArrayList<Student>();
        for (Student student: students){
            if (student.getName().equalsIgnoreCase(name)){
           studentCol.add(student);
            }
        }
        return studentCol;
    }

    @Override
    public  Student findById(int id) {
        Student searchStudents = new Student(0, null, null, null);
        for (Student student: students) {
            if(student.getId() == id){
                searchStudents.setName(student.getName());
                searchStudents.setId(student.getId());
                searchStudents.setAddress(student.getAddress());
                searchStudents.setEmail(student.getEmail());
            }

        }

        return searchStudents;
    }

    @Override
    public Collection<Student> findAll() {

        return students;
    }

    @Override
    public boolean removeStudent(Student student) {

        isStudentRemoved = false;
        if(students.contains(student)) {
            students.remove(student);
            isStudentRemoved = true;
        }
        return isStudentRemoved;
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
