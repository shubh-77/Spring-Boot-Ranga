package com.in28minutes.spring.learn_spring_framework.game;

import org.springframework.stereotype.Component;

 @Component
public class PacmanGame implements GamingConsole{

    @Override
    public void up() {
        // TODO Auto-generated method stub
        System.out.println("PacmanGame up");
    }

    @Override
    public void down() {
        // TODO Auto-generated method stub
        System.out.println("PacmanGame down");
    }

    @Override
    public void left() {
        // TODO Auto-generated method stub
        System.out.println("PacmanGame left");
    }

    @Override
    public void right() {
        // TODO Auto-generated method stub
        System.out.println("PacmanGame right");
    }



}
