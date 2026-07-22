package com.in28minutes.collections;

public class Student implements Comparable<Student> {

    private int id;
    private String name;


    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Student that) {
        // TODO Auto-generated method stub
        return Integer.compare(that.id, this.id);
    }
    
    


}
