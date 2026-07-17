package com.in28minutes.funtionalprogramming;

import java.util.List;
import java.util.Optional;

public class NPE {
public static void main(String[] args) {
    List<String> courses = List.of("apple","banana","mango");    
    Optional<String> course = courses.stream().filter(str->str.startsWith("b")).findFirst();
    System.out.println(course);
    System.out.println(course.isEmpty());
    System.out.println(course.isPresent());
    System.out.println(course.get());


}
}
