package ge.core;

import ge.doublenote.DoubleNote;
import ge.pitbull.Pitbull;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Game Engine Loading..");

        //Create Scene - Defines Border Height and Width
        Scene s = new Scene();

        //Creates Game - Defines Concrete Sprites and Logic
        Game g = new DoubleNote();

        //Start Timer
        s.Start(g);

    }
}
