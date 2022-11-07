package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void 게임랜덤테스트() {
        Game game = new Game();
        // 세 자리가 다른지 확인하기 위한 리스트
        List<Integer> dupCheck = new ArrayList<>();
        List<Integer> answer = game.getGameRandomNumber();
        // 겹치는 경우를 제외하고 dupCheck 리스트에 원소를 넣는다.
        for (int number: answer){
            if (!dupCheck.contains(number)){
                dupCheck.add(number);
            }
        }

        assertThat(answer).isEqualTo(dupCheck);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

