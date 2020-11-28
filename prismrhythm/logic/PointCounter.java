package ge.prismrhythm.logic;

public class PointCounter {

    int points;
    int multiplier;
    int streak;

    public PointCounter() {

        points = 0;
        multiplier = 1;
        streak = 0;

    }

    public void AddPoints() {

        points += 10 * multiplier;
        addToStreak();

    }

    public void addToStreak() {

        streak++;
        if(streak % 10 == 0) {
            IncreaseMultiplier();
        }
    }

    public void IncreaseMultiplier() {

        multiplier++;

    }

    public int getMultiplier() {
        return multiplier;
    }

    public void ResetStreak() {

        multiplier = 1;
        streak = 0;

    }

    public int getPoints() {
        return points;
    }
}
