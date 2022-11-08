package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void userNumber_숫자_0이_들어오는지_검증() {
        String fistZeroNumber = "012";
        String middleZeroNumber = "103";
        String endZeroNumber = "340";

        assertThatThrownBy(() -> Application.validateUserNumber(fistZeroNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number is out of range");
        assertThatThrownBy(() -> Application.validateUserNumber(middleZeroNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number is out of range");
        assertThatThrownBy(() -> Application.validateUserNumber(endZeroNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number is out of range");
    }

    @Test
    void 중복된_숫자_2개_입력() {
        //given
        String firstMiddleNumber = "112";
        String middleEndNumber = "233";
        String firstEndNumber = "191";


        //when, then
        assertThatThrownBy(() -> Application.validateUserNumber(firstMiddleNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        assertThatThrownBy(() -> Application.validateUserNumber(middleEndNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        assertThatThrownBy(() -> Application.validateUserNumber(firstEndNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
    }
    @Test
    void 중복된_숫자_3개_입력() {
        //given
        String givenNumber = "111";
        String givenNumber2 = "222";

        //when, then
        assertThatThrownBy(() -> Application.validateUserNumber(givenNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        assertThatThrownBy(() -> Application.validateUserNumber(givenNumber2))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
    }

    @Test
    void 자리수_3개_초과() {
        //given
        String givenNumber1 = "1234";
        String givenNumber2 = "987654";

        //when, then
        assertThatThrownBy(() -> Application.validateUserNumber(givenNumber1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber must be three-digit number");
        assertThatThrownBy(() -> Application.validateUserNumber(givenNumber2))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber must be three-digit number");
    }
    @Test
    void 자리수_3개_미만() {
        //given
        String givenNumber1 = "12";
        String givenNumber2 = "5";

        //when, then
        assertThatThrownBy(() -> Application.validateUserNumber(givenNumber1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber must be three-digit number");
        assertThatThrownBy(() -> Application.validateUserNumber(givenNumber2))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber must be three-digit number");
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
