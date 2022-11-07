package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest extends NsTest {
    @Test
    @DisplayName("종료 문구 출력 테스트")
    void case1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료", "새로 시작");
                },
                1, 3, 5
        );
    }

    @Test
    @DisplayName("힌트 출력 테스트")
    void case2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("248", "597", "157", "235", "135", "2");
                    assertThat(output()).contains(
                            "낫싱",
                            "1볼",
                            "1볼 1스트라이크",
                            "2스트라이크",
                            "3스트라이크",
                            "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                1, 3, 5
        );
    }

    @Test
    @DisplayName("예외: 스트라이크와 볼의 개수 허용범위 초과 테스트")
    void case3() {
        int strike = 2;
        int ball = 2;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Game.printHint(strike, ball))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외: 게임 재실행(1) 혹은 종료(2)가 아닌 다른 문자 입력한 경우")
    void case4() {
        String action = "4";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Game.validateAction(action))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
