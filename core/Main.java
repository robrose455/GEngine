package ge.core;

import ge.game.DoubleNote;
import ge.game.Game;

public class Main {

    public static void main(String[] args) {

        System.out.println("Game Engine Loading..");

        //Create Scene - Defines Border Height and Width
        Scene s = new Scene();

        //Creates Game - Defines Concrete Sprites and Logic
        Game g = new DoubleNote();

        //Start Timer
        s.Start(g);

    }
}
