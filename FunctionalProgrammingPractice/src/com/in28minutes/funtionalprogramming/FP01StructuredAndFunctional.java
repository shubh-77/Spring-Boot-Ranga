package com.in28minutes.functionalprogramming;

import java.util.List;

public class FP01StructuredAndFunctional {

 

    private static void printAllNumbersInListStructured(List<Integer> list){
        //How to loop the numbers
        System.out.println("List elements: ");
        for(int i:list){
            System.out.print(i+" ");
        }
    }
    private static void printEvenNumbersInListStructured(List<Integer> list){
        System.out.println("Even List elements: ");
        for(int i :list){
            if(i%2==0){
                System.out.println(i+" ");

            }
        }
    }

    private static void printEvenNumbersInListFP(List<Integer> list){
        System.out.println("\nList of even elements using FP:");
        list.stream().filter(n->n%2==0).forEach(System.out::println);
    }

    private static void printAllNumbersInListFP(List<Integer> list){
        //what needs to be done
        System.out.println("\nList elements using FP:");
        list.stream().forEach(System.out::println);
    }
    private static void printSquaresOfEvenNumbersInListFP(List<Integer> list){
            System.out.println("\nList of squares of even elements using FP:");
            list.stream().filter(n->n%2==0)
            .map(n->n*n)
            .forEach(System.out::println);

    }
    public static void main(String[] args) {
        
        //printAllNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
        printEvenNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));

        // printAllNumbersInListFP(List.of(12,9,13,4,6,2,4,12,15));

        printEvenNumbersInListFP(List.of(12,9,13,4,6,2,4,12,15));

        printSquaresOfEvenNumbersInListFP(List.of(12,9,13,4,6,2,4,12,15));


    }
}
