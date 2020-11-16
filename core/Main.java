package ge.core;

import ge.game.DoubleNote;
import ge.game.Game;

public class Main {

    public static void main(String[] args) {

        System.out.println("Game Engine Loading..");
        Scene s = new Scene();
        Game g = new DoubleNote(s);
        s.Start(g);

    }
}