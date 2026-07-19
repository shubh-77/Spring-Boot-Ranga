package com.in28minutes.springboot.learn_spring_boot;

/**
 * Course
 */
public class Course {

    private long id;
    private String name;
    private String author;


    public Course(long id, String name, String author) {
        //TODO Auto-generated constructor stub
        this.id= id;
        this.name=name;
        this.author=author;
    }

    public void setId(long id){
        this.id=id;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }


    

}
