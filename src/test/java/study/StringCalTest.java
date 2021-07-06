package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalTest {
    // String value = scanner.nextLine();

    @DisplayName("문자열 계산기")
    @CsvSource(value = {"2 + 3 * 4 / 2, 10"})
    @ParameterizedTest
    void cal(String input, int expected) {
        String[] array = input.split(" ");

        int actual = -1;

        for (int i = 0; i < array.length; i++) {

            if (!isItSign(array[i])) {
                if (actual == -1) {
                    actual = Integer.parseInt(array[i]);
                } else {
                    actual = process(actual, Integer.parseInt(array[i]), array[i - 1]);
                }
            }
        }

        System.out.println("result = " + actual);
        assertThat(expected == actual).isTrue();
    }

    private boolean isItSign(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/");
    }

    private int process(int previous, int current, String sign) {
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
