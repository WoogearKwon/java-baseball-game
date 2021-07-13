package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {
    private Balls answers;

    @BeforeEach
    void setUp() {
        answers = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_3strike() {
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void play_1strike_1ball() {
        PlayResult result = answers.play(Arrays.asList(1, 3, 6));
        assertThat(result.getStrikes() == 1).isTrue();
        assertThat(result.getBalls() == 1).isTrue();
    }

    @Test
    void play_nothing() {
        PlayResult result = answers.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrikes() == 0).isTrue();
        assertThat(result.getBalls() == 0).isTrue();
    }

    @Test
    void strike() {
        BallStatus status = answers.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = answers.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
