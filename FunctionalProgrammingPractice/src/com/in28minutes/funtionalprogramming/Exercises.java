package com.in28minutes.funtionalprogramming;

import java.util.List;

public class Exercises {
    
    
    
    public static void main(String[] args) {
        // 1. print odd numbers
        System.out.println("\nprint all odd numbers");

        List.of(12,9,13,4,6,2,4,12,15)
        .stream()
        .filter(n->n%2==1)
        .forEach(n->System.out.print(n+" "));
        
        System.out.println("\nprint all courses individually");
        // 2. print all courses inddvidually
        List<String> courses = List.of("Spring","Spring Boot","API","Microservice","AWS","PCF","Azure","Docker","Kubernetes");
        courses.stream().forEach(System.out::println);


        System.out.println("\nprint all courses having word spring");
        courses.stream().filter(str->str.contains("Spring")).forEach(System.out::println);


        System.out.println("\nPrint course having only 4 letters");
        courses.stream().filter(str->str.length()>=4).forEach(System.out::println);


        System.out.println("\n Print the cubes of odd numbers");
        
        List.of(12,9,13,4,6,2,4,12,15)
        .stream()
        .filter(n->n%2==1)
        .map(n->n*n*n)
        .forEach(System.out::println);

        

         System.out.println("\nPrint number of characters in course");
         courses.stream().map(str->str +" "+str.length()).forEach(str->System.out.println(str));

    }

}
