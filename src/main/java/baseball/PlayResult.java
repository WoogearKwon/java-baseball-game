package baseball;

public class PlayResult {
    private int strikes;
    private int balls;

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
}
