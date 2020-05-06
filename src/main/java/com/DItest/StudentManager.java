package com.DItest;

import lombok.Data;

@Data
public class StudentManager {

    Student student;

    public void show(){
        Student student = new Student();
        student.setId(22);
        student.setName("allen");
        System.out.println(student.getId());
        System.out.println(student.getName());
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.show();
    }
}
