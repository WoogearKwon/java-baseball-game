package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseballTest {

    @Test
    void generateNumbers() {
        Baseball game = new Baseball();
        int numbers = game.generateNumbers();
        boolean isInRange = numbers > 0 && numbers < 10;
        assertThat(isInRange).isTrue();
    }
}
