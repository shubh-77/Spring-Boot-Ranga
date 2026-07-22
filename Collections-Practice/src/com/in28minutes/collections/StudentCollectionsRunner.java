package com.in28minutes.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

class AscendingStudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getId(), student2.getId());
    }
   
}

public class StudentCollectionsRunner {

    public static void main(String[] args) {
        
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Ranga"));
      
        students.add(new Student(3,"Eve"));
        students.add(new Student(2,"Adam"));

        System.out.println("Student list: "+students);
        Collections.sort(students);
        System.out.println("Sorted Student list by id in reverse order: "+ students);

        Collections.sort(students, new AscendingStudentComparator());
        System.out.println("Normal order comparator:"+students);
    }
}
