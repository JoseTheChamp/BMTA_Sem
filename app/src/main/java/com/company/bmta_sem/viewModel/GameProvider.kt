package com.company.bmta_sem.viewModel

class GameProvider() {
    companion object {
        lateinit var game : Game

        fun init(json : String){
            game = Game(json)
        }
    }
}

/*


    companion object {
        var game : Game = null
    }


public class Singleton  {

    private static Singleton INSTANCE = null;

    // other instance variables can be here

    private Singleton() {};

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return(INSTANCE);
    }

    // other instance methods can follow
}


 */