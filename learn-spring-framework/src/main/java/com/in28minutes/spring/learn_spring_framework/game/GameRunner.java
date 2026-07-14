package com.in28minutes.spring.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * GameRunner
 */
@Component
public class GameRunner {


    
    // private MarioGame game;
        // private SuperContraGame game;
        @Autowired
        private GamingConsole gc;

    public GameRunner(GamingConsole gc) {
        this.gc = gc;
    }


    public void run() {
         gc.up();
         gc.down();
        gc.left();
        gc.right();
    }

}
