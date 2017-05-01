package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int age;
    private String name;
    private List<Student> students = new ArrayList<>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = 0;
        Student studentWithMaxAverageGrade = null;
        for (Student student : students) {
            double studentAverageGrade = student.getAverageGrade();
            if (studentAverageGrade > maxAverageGrade) {
                maxAverageGrade = studentAverageGrade;
                studentWithMaxAverageGrade = student;
            }
        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        double minAverageGrade = Double.MAX_VALUE;
        Student studentWithMinAverageGrade = null;
        for (Student student : students) {
            double studentAverageGrade = student.getAverageGrade();
            if (studentAverageGrade < minAverageGrade) {
                minAverageGrade = studentAverageGrade;
                studentWithMinAverageGrade = student;
            }
        }
        return studentWithMinAverageGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}