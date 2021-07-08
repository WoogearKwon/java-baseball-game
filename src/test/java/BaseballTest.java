import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {
    static BaseballGame baseballGame;

    @BeforeAll
    static void setBaseballGame() {
        baseballGame = new BaseballGame();
    }

    @Test
    void testInputValid() {
        assertThat(baseballGame.isInputValid("124")).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"879,879"})
    void testIsInputCorrect(String input, String answer) {
        assertThat(baseballGame.isInputCorrect(input, answer)).isTrue();
    }
}
