package ge;

public class Main {

    public static void main(String[] args) {

        System.out.println("Game Engine Loading..");
        Scene s = new Scene();
        Game g = new TwoCran(s);
        s.Start(g);

    }
}
