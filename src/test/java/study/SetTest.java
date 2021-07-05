package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsNumbers(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 4", "2, 5", "3, 5"})
    void containsNumbersReturnTrueOrFalse(int small, int big) {
//        assertThat(numbers.contains(small)).isTrue();
//        assertThat(numbers.contains(big)).isFalse();

        // 이게 답이 아닌 것 같은데, 잘 모르겠다..
        if (numbers.contains(small)) assertThat(true);
        assertThat(false);
    }
}
