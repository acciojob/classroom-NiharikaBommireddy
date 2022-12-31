package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@Service
public class StudentService {
    StudentRepository studentRepository;
    @Autowired
    public void addStudent(Student student)
    {
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher)
    {
        studentRepository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String stuName,String techName)
    {
        studentRepository.addStudentTeacherPair(stuName,techName);
    }
    public Student getStudentByName(String name)
    {
        return studentRepository.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name)
    {
        return studentRepository.getTeacherByName(name);
    }
    public List<String> getStudentByTeacherName(String teacherName)
    {
        return studentRepository.getStudentsByTeacherName(teacherName);
    }
    public List<String> getAllStudents()
    {
        return studentRepository.getAllStudents();
    }
    public void deleteTeacherByName(String teacherName)
    {
        studentRepository.deleteTeacherByName(teacherName);
    }
    public void deleteAllTeachers()
    {
        studentRepository.deleteAllTeachers();
    }

}
