package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void charAt() {
        String actual = "abc";
        assertThatThrownBy(() -> {
           // ..
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size 2");
    }

    /*
    자주 발생하는 Exception의 경우 예외별 메서드 제공

    * assertThatIllegalArgumentException()
    * assertThatIllegalStateException()
    * assertThatIOException()
    * assertThatNullPointerException()
    * */
}
