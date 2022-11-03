package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    @DisplayName("1 ~ 9 사이의 값으로 중복 없이 설정되는지 테스트")
    @Test
    void setNumberTest() {

        int testNumber = 1000;
        boolean result = false;
        String number;

        for (int tryNumber = 0; tryNumber < testNumber; tryNumber++) {
            number = Application.setNumber();
            result = checkSetNumber(number);
            if (result == false) {
                break;
            }
        }

        assertThat(result).isTrue();
    }

    private boolean checkSetNumber(String number) {

        if (number.length() != 3) {
            return false;
        }

        char first = number.charAt(0);
        char second = number.charAt(1);
        char third = number.charAt(2);

        if (first == second || first == third || second == third) {
            return false;
        }

        boolean digitCheckResult = true;
        digitCheckResult = isDigitExceptZero(first);
        digitCheckResult = isDigitExceptZero(second);
        digitCheckResult = isDigitExceptZero(third);

        if (digitCheckResult == false) {
            return false;
        }

        return true;
    }

    private boolean isDigitExceptZero(char digit) {

        if (digit > '0' && digit <= '9') {
            return true;
        } else {
            return false;
        }
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
