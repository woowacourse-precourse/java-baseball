package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Nested;
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

    @Nested
    class 종료_테스트 {
        @Test
        void 게임종료_후_재시작() {
            Game baseballGame = new Game();
            String answer = getAnswer(baseballGame);
            baseballGame.operate(answer);
            baseballGame.operate("1");
            assertThat(output()).doesNotContain("게임종료");
        }
    }

    @Nested
    class 예외_테스트 {
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
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
