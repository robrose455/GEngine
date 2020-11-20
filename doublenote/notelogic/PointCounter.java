package ge.doublenote.notelogic;

public class PointCounter {

    int points;

    public PointCounter() {

        points = 0;

    }

    public void addPoints(int addedPoints) {

        points += addedPoints;

    }

    public int getPoints() {
        return points;
    }
}
