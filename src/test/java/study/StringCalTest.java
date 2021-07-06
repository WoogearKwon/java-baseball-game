package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalTest {
    private int actual = -1;
    // String value = scanner.nextLine();

    @DisplayName("문자열 계산기")
    @CsvSource(value = {"2 + 4 * 3 / 6, 3"})
    @ParameterizedTest
    void cal(String input, int expected) {
        String[] array = input.split(" ");

        for (int i = 0; i < array.length; i++) {
            process(i, array);
        }

        System.out.println("result = " + actual);
        assertThat(expected == actual).isTrue();
    }

    private void process(int i, String[] array) {
        if (shouldProcess(i)) {
            setActualValue(i, array);
        }
    }

    private void setActualValue(int i, String[] array) {
        if (actual == -1) {
            actual = Integer.parseInt(array[i]);
            return;
        }

        int currentValue = Integer.parseInt(array[i]);
        String mathSign = array[i - 1];
        actual = calculate(actual, currentValue, mathSign);
    }

    private boolean shouldProcess(int i) {
        return (i % 2 == 0);
    }

    private int calculate(int previous, int current, String sign) {
        if (sign.equals("+")) {
            return previous + current;
        }

        if (sign.equals("-")) {
            return previous - current;
        }

        if (sign.equals("*")) {
            return previous * current;
        }

        if (sign.equals("/")) {
            return previous / current;
        }

        return previous;
    }
}
