package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 새로운_수_얻기() {
        assertRandomNumberInRangeTest(
                () -> {
                    List <Integer> newNums = Application.getNewNumber();
                    assertThat(newNums).isEqualTo(new ArrayList<>(Arrays.asList(1,2,3)));
                },
                1, 1, 1, 2, 3
        );
    }

    @Test
    void 입력_유효_판단() {
        assertThat(Application.isRightInput("134")).isEqualTo(true);
        assertThat(Application.isRightInput("224")).isEqualTo(false);
        assertThat(Application.isRightInput("45677")).isEqualTo(false);
    }

    @Test
    void 스트라이크_개수_얻기() {
        assertThat(Application.getStrikeCount(new ArrayList<>(Arrays.asList(1,2,3)), "123")).isEqualTo(3);
        assertThat(Application.getStrikeCount(new ArrayList<>(Arrays.asList(1,2,9)), "123")).isEqualTo(2);
    }

    @Test
    void 볼_개수_얻기() {
        assertThat(Application.getBallCount(new ArrayList<>(Arrays.asList(1,2,3)), "123")).isEqualTo(0);
        assertThat(Application.getBallCount(new ArrayList<>(Arrays.asList(2,1,9)), "623")).isEqualTo(1);
        assertThat(Application.getBallCount(new ArrayList<>(Arrays.asList(2,1,9)), "923")).isEqualTo(2);
    }
}
