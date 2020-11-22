package ge.doublenote.definition;

import ge.core.Game;
import ge.core.Scene;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        System.out.println("Game Engine Loading..");

        //Create Scene - Defines Border Height and Width
        Scene s = new Scene();

        //Creates Game - Defines Concrete Sprites and Logic
        Game g = new DoubleNote();

        //Start Timer
        s.Start(g);

    }
}
