package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();
    HashMap<String,List<String>> pairsDb = new HashMap<>();

    public void addStudent(Student student)
    {
        studentDb.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher)
    {
        teacherDb.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String studentName,String teacherName)
    {

        if(studentDb.containsKey(studentName)&&teacherDb.containsKey(teacherName))
        {
            List<String> ls;
            if(pairsDb.containsKey(teacherName))
            {
                 ls = pairsDb.get(teacherName);
            }
            else {
                ls = new ArrayList<>();
            }
            ls.add(studentName);
            pairsDb.put(teacherName,ls);
        }
    }
    public Student getStudentByName(String name)
    {
        return studentDb.get(name);
    }
    public Teacher getTeacherByName(String name)
    {
        return teacherDb.get(name);
    }
    public List<String> getAllStudents()
    {
        List<String> ls = new ArrayList<>();
        for(String s : studentDb.keySet())
            ls.add(s);
        return new ArrayList<>(ls);
    }
    public void deleteTeacherByName(String teacherName)
    {
        if(teacherDb.containsKey(teacherName))
        {
            if(pairsDb.containsKey(teacherName))
            {
                List<String> st = pairsDb.get(teacherName);
                for(String s : st)
                {
                    if(studentDb.containsKey(s)) studentDb.remove(s);
                }
                teacherDb.remove(teacherName);
                pairsDb.remove(teacherName);
            }
        }
    }
    public List<String> getStudentsByTeacherName(String teacherName)
    {
        return pairsDb.get(teacherName);
    }

    public void deleteAllTeachers()
    {
        for(String teacherName : teacherDb.keySet())
        {
           if(pairsDb.containsKey(teacherName))
           {
               List<String> studentList = pairsDb.get(teacherName);
               for(String s : studentList)
               {
                   if(studentDb.containsKey(s)) studentDb.remove(s);
               }
           }
           pairsDb.remove(teacherName);
           teacherDb.remove(teacherName);
        }
        pairsDb.clear();
        teacherDb.clear();
    }


}
