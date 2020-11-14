package ge.core;

import ge.Game;
import ge.DoubleNote;

public class Main {

    public static void main(String[] args) {

        System.out.println("Game Engine Loading..");
        Scene s = new Scene();
        Game g = new DoubleNote(s);
        s.Start(g);

    }
}
