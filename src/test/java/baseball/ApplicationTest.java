package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
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
    void selectPlayMoreGame() {
    }

    @Test
    void playBaseBallGameOneCycle() {
    }

    @Test
    void printResult() {
    }

    @Test
    void checkMatchNumber() {
    }

    @Test
    void getStrikeCount() {
    }

    @Test
    void getBallCount() {
    }

    @Test
    void getUserInput() {
    }

    @Test
    void checkUserInput() {
    }

    @Test
    void makeRandomNumber() {
    }

    @Test
    @DisplayName("랜덤한 숫자들 생성")
    void makeRandomNumbers() {
        ArrayList<Integer> computerNumber = new ArrayList<>();
        Application.makeRandomNumbers(computerNumber);
        assertThat(computerNumber.size()).isEqualTo(3);
        assertThat(computerNumber.stream().allMatch(v->v>=1&&v<=9)).isTrue();
    }

    @Test
    @DisplayName("리스트에 숫자 추가")
    void 리스트에숫자추가하기() {
        ArrayList<Integer> computerNumber = new ArrayList<>();
        Application.addRandomOneNumber(computerNumber,1);
        assertThat(computerNumber).contains(1);
    }
}
