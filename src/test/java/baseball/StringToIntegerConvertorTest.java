package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringToIntegerConvertorTest {
    @Test
    void convert_메서드는_문자열을_입력받고_정수를_반환() {
        String input = "123";

        int convertedNumber = StringToIntegerConvertor.convert(input);

        assertThat(convertedNumber).isEqualTo(123);
    }
}
