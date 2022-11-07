package baseball;

import baseball.domain.Game;
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
    void 많은_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    void 스트라이크_볼_판단_테스트() {
//        int[] gameNumber = {4,5,6};
//        int[] userNumber = {4,6,8};
//
//        for(int i = 0; i < 3; i++){
//            baseball.service.GameService.compute(gameNumber,userNumber,i);
//        }
//
//        int [] result = {Game.strikeCount,Game.ballCount};
//        int [] testNum = {1, 1};
//
//        assertThat(result).isEqualTo(testNum);
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
