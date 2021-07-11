package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseballTest {
    Baseball game;

    @BeforeEach
    void setUp() {
        game = new Baseball();
    }

    @Test
    void generateNumbers() {
        int numbers = game.generateNumbers();
        boolean isInRange = numbers > 0 && numbers < 10;
        assertThat(isInRange).isTrue();
    }

    @Test
    void wrong_length_input() {
        assertThat(game.isInputValid("1234")).isFalse();
    }

    @Test
    void empty_input() {
        assertThat(game.isInputValid("")).isFalse();
    }

    @Test
    void non_numeric_input() {
        assertThat(game.isInputValid("12d")).isFalse();
    }
}
