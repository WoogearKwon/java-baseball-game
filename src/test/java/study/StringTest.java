package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] numbers = "1,2".split(",");
        assertThat(numbers).contains("1", "2");
        assertThat(numbers).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String sub = "(1,2)".substring(1,3);
        assertThat(sub).isEqualTo(sub);
    }

    @Test
    @DisplayName("Exception Capturing Test")
    void charAt() {
        String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(4); // throws IndexOutOfBoundsException
            /*
            * 조건1: asserThatThrownBy 안에서 예외가 발생
            * 조건2: 예외 타입은 IndexOutOfBoundsExceptons
            * 조건3: 예외 메시지는 다음을 포함 - hasMessageContaining()
            * */
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    actual.charAt(4);
                }).withMessageMatching("String index out of range: 4");

        /*
        자주 발생하는 Exception의 경우 예외별 메서드 제공
        * assertThatIllegalArgumentException()
        * assertThatIllegalStateException()
        * assertThatIOException()
        * assertThatNullPointerException()
        * */
    }

    // test code
}
