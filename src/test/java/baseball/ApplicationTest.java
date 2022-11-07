package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {


    private String getAnswer(Game game) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> answerNumbers = game.getAnswerNumbers();
        answerNumbers.stream()
                .map(number -> Integer.toString(number))
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
    @Test
    void 스트라이크_테스트() {
        Game baseballGame = new Game();
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
    void 볼_테스트() {
        Game baseballGame = new Game();
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
    void 낫싱_테스트() {
        Game baseballGame = new Game();
        baseballGame.operate("000");
        assertThat(output()).contains("낫싱");
    }

    @Test
    void 게임종료_후_재시작() {
        Game baseballGame = new Game();
        String answer = getAnswer(baseballGame);
        baseballGame.operate(answer);
        baseballGame.operate("1");
        assertThat(output()).doesNotContain("게임종료");
    }

    @Test
    void 입력_예외_테스트() {
        boolean exceptionCaught = false;
        Game baseballGame = new Game();
        try {
            baseballGame.operate("1234");
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
