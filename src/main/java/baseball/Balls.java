package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = mapBalls(answers);
    }

    private static List<Ball> mapBalls(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> ballNumbers) {
        Balls userBalls = new Balls(ballNumbers);
        PlayResult result = new PlayResult();

        for (Ball ball : balls) {
            BallStatus status = userBalls.play(ball);
            result.report(status);
        }

        return result;
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
                .map(answer -> answer.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
