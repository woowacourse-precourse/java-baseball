package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    // 추가 테스트
    @Test
    @DisplayName("입력의 길이가 3이 아닌 경우 ")
    public void inputLenNot3() throws Exception{
        assertThatThrownBy(()-> Application.checkAndConvertUserInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("서로 다른 3개의 수가 아닌 경우")
    public void duplicationNumber() throws Exception{
        assertThatThrownBy(()-> Application.checkAndConvertUserInput("133"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("수가 아닌 입력이 있는 경우")
    public void NotNumber() throws Exception{
        assertThatThrownBy(()->Application.checkAndConvertUserInput("a12"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName(" 0 볼 경우 ")
    public void zeroBallScenario() throws Exception{
        List<Integer> computer  = List.of(1,2,3);
        List<Integer> user = List.of(4,5,6);

        int ball = Application.calculateBall(computer,user);
        assertThat(ball).isEqualTo(0);
    }
    @Test
    @DisplayName(" 1 볼 경우 ")
    public void oneBallScenario() throws Exception{
        List<Integer> computer  = List.of(1,4,3);
        List<Integer> user = List.of(4,5,6);

        int ball = Application.calculateBall(computer,user);
        assertThat(ball).isEqualTo(1);
    }
    @Test
    @DisplayName(" 2 볼 경우 ")
    public void twoBallScenario() throws Exception{
        List<Integer> computer  = List.of(1,4,5);
        List<Integer> user = List.of(4,5,6);

        int ball = Application.calculateBall(computer,user);
        assertThat(ball).isEqualTo(2);
    }
    @Test
    @DisplayName(" 3 볼 경우 ")
    public void threeBallScenario() throws Exception{
        List<Integer> computer  = List.of(6,4,5);
        List<Integer> user = List.of(4,5,6);

        int ball = Application.calculateBall(computer,user);
        assertThat(ball).isEqualTo(3);
    }
}
