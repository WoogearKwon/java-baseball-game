package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {
    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(1, 4);
    }

    @Test
    void strike() {
        BallStatus status = ball.play(new Ball(1, 4));
        assertThat(status == BallStatus.STRIKE).isTrue();
    }

    @Test
    void ball() {
        BallStatus status = ball.play(new Ball(2, 4));
        assertThat(status == BallStatus.BALL).isTrue();
    }

    @Test
    void nothing() {
        BallStatus status = ball.play(new Ball(2, 3));
        assertThat(status == BallStatus.NOTHING).isTrue();
    }
}
