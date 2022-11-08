package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void splitStrNumberToList_테스트() {
        String number = "123";
        List<Integer> numberList = List.of(1, 2, 3);

        List<Integer> splitedList = Application.splitStrNumberToList(number);

        assertThat(numberList).isEqualTo(splitedList);
    }

    @Test
    void 중복된_숫자로_구성된_야구숫자_예외_테스트() {
        String baseballNumber = "112";

        assertThrows(IllegalArgumentException.class,
                () -> Application.validateDuplicateBaseballNumber(baseballNumber));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
