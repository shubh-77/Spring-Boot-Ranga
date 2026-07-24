package com.in28minutes.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExercise {
public static void main(String[] args) {
    List<Character> characters = List.of('A','Z','A','B','Z','F');

    Set<Character> charSet  = new HashSet<>(characters);
    System.out.println("Set of characters: " + charSet);


    Set<Character> charLinkedHashSet  = new LinkedHashSet<>(characters);
    System.out.println("Set of characters in insertion order: " + charLinkedHashSet);

    Set<Character> charTreeSet  = new TreeSet<>(characters);
    System.out.println("Set of characters in sorted order: " + charTreeSet);





}
}
