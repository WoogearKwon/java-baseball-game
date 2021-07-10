package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {
    private Balls answerBalls;

    @BeforeEach
    void setUp() {
        answerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_nothing() {
        PlayResult playResult = answerBalls.play(Arrays.asList(4, 5, 6));
        assertThat(playResult.getStrike()).isEqualTo(0);
        assertThat(playResult.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        PlayResult playResult = answerBalls.play(Arrays.asList(1, 4, 2));
        assertThat(playResult.getStrike()).isEqualTo(1);
        assertThat(playResult.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        PlayResult playResult = answerBalls.play(Arrays.asList(1, 2, 3));
        assertThat(playResult.isGameEnd()).isTrue();
    }

    @Test
    void strike() {
        BallStatus status = answerBalls.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = answerBalls.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = answerBalls.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
