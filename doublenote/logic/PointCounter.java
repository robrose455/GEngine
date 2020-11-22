package ge.doublenote.logic;

public class PointCounter {

    int points;

    public PointCounter() {

        points = 0;

    }

    public void AddPoints(int addedPoints) {

        points += addedPoints;

    }

    public void ResetPoints() {

        points = 0;

    }

    public int getPoints() {
        return points;
    }
}
