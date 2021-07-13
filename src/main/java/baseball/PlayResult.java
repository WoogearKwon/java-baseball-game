package baseball;

public class PlayResult {
    private int strikes = 0;
    private int balls = 0;

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            strikes++;
            return;
        }
        if (status.isBall()) {
            balls++;
            return;
        }
    }

    public boolean isGameEnd() {
        return strikes == 3;
    }
}
