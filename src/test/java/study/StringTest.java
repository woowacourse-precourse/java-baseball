package study;

import baseball.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class StringTest {
    Application application;

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    @DisplayName("UserNum의 에러 확인")
    void isRightUSerNum_테스트() {
        String input = "222";
        IllegalArgumentException e= Assertions.assertThrows(IllegalArgumentException.class, () ->  application.isRightUserNum(input));
        assertThat(e.getMessage()).isEqualTo("올바른 값을 입력하세요. 게임을 종료합니다.");
    }

    @Test
    @DisplayName("Choice의 에러 확인")
    void isRightChoice_테스트() {
        String input="abc";
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> application.isRightChoice(input));
        assertThat(e.getMessage()).isEqualTo("올바른 값을 입력하세요. 게임을 종료합니다.");

    }

    // analyseNumber() 메서드의 경우, Terminal에 결과가 출력되어 직접 확인 가능하므로 생략

    @Test
    @DisplayName("userNum과 randomNum을 적절히 분석하는지 확인")
    void analyseNumber_테스트() {
        String randomNum="156";
        String userNum="576";
        assertThat(application.analyseNumber(randomNum, userNum)).containsExactly(1, 1);

        randomNum="123";
        userNum="456";
        assertThat(application.analyseNumber(randomNum, userNum)).containsExactly(0, 0);

        randomNum="123";
        userNum="124";
        assertThat(application.analyseNumber(randomNum, userNum)).containsExactly(2, 0);

    }

    @Test
    @DisplayName("RandomNum 적절히 생성했는지 확인")
    void makeRandomNum_테스트() {

    }

}
