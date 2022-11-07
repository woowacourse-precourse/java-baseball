package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Constants.Status;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("숫자 야구 게임은")
class ApplicationTest extends NsTest {


    private String getAnswer(BaseballGame baseballGame) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> answerNumbers = baseballGame.getAnswerNumbers();
        answerNumbers.stream()
                .map(number -> Integer.toString(number))
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
    @Test
    @Order(1)
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크라고 알려줘야 합니다.")
    void 스트라이크_테스트() {
        BaseballGame baseballGame = new BaseballGame();
        String answer = getAnswer(baseballGame);
        String strike1 = answer.substring(0, 1) + "00";
        String strike2 = answer.substring(0, 2) + "0";
        String strike3 = answer;
        baseballGame.operate(strike1);
        assertThat(output()).contains("1스트라이크");
        baseballGame.operate(strike2);
        assertThat(output()).contains("2스트라이크");
        baseballGame.operate(strike3);
        assertThat(output()).contains("3스트라이크");
    }

    @Test
    @Order(2)
    @DisplayName("같은 수가 다른 자리에 있으면 볼이라고 알려줘야 합니다.")
    void 볼_테스트() {
        BaseballGame baseballGame = new BaseballGame();
        String answer = getAnswer(baseballGame);
        String ball1 = answer.substring(1, 2) + "00";
        String ball2 = answer.substring(1, 3) + "0";
        String ball3 = answer.substring(1, 3) + answer.charAt(0);
        baseballGame.operate(ball1);
        assertThat(output()).contains("1볼");
        baseballGame.operate(ball2);
        assertThat(output()).contains("2볼");
        baseballGame.operate(ball3);
        assertThat(output()).contains("3볼");
    }

    @Test
    @Order(3)
    @DisplayName("같은 수가 전혀 없으면 낫싱이라고 알려줘야 합니다.")
    void 낫싱_테스트() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.operate("000");
        assertThat(output()).contains("낫싱");
    }

    @Test
    @Order(4)
    @DisplayName("게임을 종료한 후 1을 입력해 게임을 다시 시작할 수 있어야 합니다.")
    void 게임종료_후_재시작() {
        BaseballGame baseballGame = new BaseballGame();
        String answer = getAnswer(baseballGame);
        baseballGame.operate(answer);
        baseballGame.operate("1");
        assertThat(baseballGame.getStatus()).isEqualTo(Status.PLAYING);
    }

    @Test
    @Order(5)
    @DisplayName("게임을 종료한 후 2를 입력해 완전히 종료할 수 있어야 합니다.")
    void 게임종료_후_끝() {
        BaseballGame baseballGame = new BaseballGame();
        String answer = getAnswer(baseballGame);
        baseballGame.operate(answer);
        baseballGame.operate("2");
        assertThat(baseballGame.getStatus()).isEqualTo(Status.DONE);
    }

    @Test
    @Order(6)
    @DisplayName("게임 도중 게임 후 명령을 입력하면 예외를 반환합니다.")
    void 입력_예외_테스트() {
        boolean exceptionCaught = false;
        BaseballGame baseballGame = new BaseballGame();
        try {
            baseballGame.operate("1234");
        } catch (IllegalArgumentException e) {
            exceptionCaught = true;
        }
        assertThat(exceptionCaught).isTrue();
    }

    @Test
    @Order(7)
    @DisplayName("게임 종료 후 추측 명령어를 입력하면 예외를 반환합니다.")
    void 종료_예외_테스트() {
        boolean exceptionCaught = false;
        BaseballGame baseballGame = new BaseballGame();
        String answer = getAnswer(baseballGame);
        baseballGame.operate(answer);
        try {
            baseballGame.operate("123");
        } catch (IllegalArgumentException e) {
            exceptionCaught = true;
        }
        assertThat(exceptionCaught).isTrue();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
