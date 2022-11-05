package baseball.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void isNullOrEmpty_함수로_빈_문자열_사용시_true_반환() {
        boolean result = StringUtil.isNullOrEmpty("");

        assertThat(result).isTrue();
    }

    @Test
    void isNullOrEmpty_함수로_null_사용시_true_반환() {
        boolean result = StringUtil.isNullOrEmpty(null);

        assertThat(result).isTrue();
    }

    @Test
    void isNullOrEmpty_함수로_공백_문자열_사용시_true_반환() {
        boolean result = StringUtil.isNullOrEmpty("     ");

        assertThat(result).isTrue();
    }

    @Test
    void isNullOrEmpty_함수로_내용이_있는_문자열_사용시_true_반환() {
        boolean result = StringUtil.isNullOrEmpty("result");

        assertThat(result).isFalse();
    }
}