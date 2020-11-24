package ge.doublenote;

import ge.core.Game;
import ge.core.Scene;
import ge.doublenote.game.DoubleNote;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Game Engine Loading..");

        //Create Scene - Defines Border Height and Width
        Scene s = new Scene();

        //Creates Game - Defines Concrete Sprites and Logic
        Game g = new DoubleNote();

        //Start Timer
        s.Start(g);

    }
}
