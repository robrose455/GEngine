package ge.core;

import ge.core.SceneManager;

public class GameStateManager {

    SceneManager sm;
    boolean winner;

    public GameStateManager(SceneManager sm) {

        this.sm = sm;
        winner = false;

    }

    public boolean isWinner() {
        return winner;
    }

    public void Win() {
        winner = true;
    }


}
