package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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

    @Test
    void selectNumbers_임의의_수_3개_리스트에_넣어서_반환() {
        int size = Application.selectNumbers().size();
        int firstNumber = Application.selectNumbers().get(0);
        int secondNumber = Application.selectNumbers().get(1);
        int thirdNumber = Application.selectNumbers().get(2);

        assertThat(size).isEqualTo(3);
        assertThat(firstNumber).isNotEqualTo(secondNumber);
        assertThat(secondNumber).isNotEqualTo(thirdNumber);
        assertThat(thirdNumber).isNotEqualTo(firstNumber);
    }

    @Test
    void validateUserNumbers_사용자가_조건에_부합하지_않는_수를_입력했을_때_예외발생() {
        String input = "1234";

        assertThatThrownBy(() -> Application.validateUserNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리가 아닌 수를 입력하였습니다.");

        String input2 = "a13";

        assertThatThrownBy(() -> Application.validateUserNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값을 입력하였습니다.");

        String input3 = "112";

        assertThatThrownBy(() -> Application.validateUserNumbers(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수를 입력하였습니다.");
    }

    @Test
    void addToList_입력받은_값을_리스트에_추가() {
        String input = "123";

        assertThat(Application.addToList(input)).contains(1, 2, 3);
    }
}
