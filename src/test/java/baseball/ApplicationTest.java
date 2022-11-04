package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void 컴퓨터의_수_제대로_생성되었는지_확인() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> numArr = Application.makeComputerRandomNumber();
            assertThat(numArr).hasSize(3);

            assertThat(numArr.get(0))
                    .isNotEqualTo(numArr.get(1))
                    .isNotEqualTo(numArr.get(2));

            assertThat(numArr.get(1))
                    .isNotEqualTo(numArr.get(2));
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
