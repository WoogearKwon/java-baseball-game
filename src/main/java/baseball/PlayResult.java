package baseball;

public class PlayResult {
    private int strikes = 0;
    private int balls = 0;

    public int getStrike() {
        return strikes;
    }

    public int getBall() {
        return balls;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            strikes++;
            return;
        }

        if (status.isBall()) {
            balls++;
        }
    }

    public boolean isGameEnd() {
        return strikes == 3;
    }
}
