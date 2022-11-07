package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberManagerTest {

    private static final NumberManager numberManager = new NumberManager();
    private static String answer;

    @BeforeAll
    static void init() throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        NumberManager.setAnswer();

        Field numberManager_answer = numberManager.getClass().getDeclaredField("answer");
        numberManager_answer.setAccessible(true);

        answer = (String) numberManager_answer.get(numberManager_answer);
    }

    @Test
    void answer_생성_시_길이_테스트() {
        assertThat(3).isEqualTo(answer.length());
    }

    @Test
    void answer_생성_시_각_자리_숫자_범위_테스트() {
        assertThat(true).isEqualTo(UserManager.checkPredictInput_regex(answer));
    }

    @Test
    void answer_생성_시_중복_테스트() {
        assertThat(true).isEqualTo(UserManager.checkPredictInput_duplicate(answer));
    }

    @Test
    void getHint_3스트라이크_테스트() {
        NumberManager.getHint(answer);
        assertThat("3스트라이크").isEqualTo(GameManager.getHintString());
    }

    @Test
    void getHint_볼_테스트() {
        StringBuilder ball = new StringBuilder();
        for (int i = 1; i <= answer.length(); i++) {
            ball.append(answer.charAt(i % 3));
        }
        NumberManager.getHint(ball.toString());

        assertThat("3볼 ").isEqualTo(GameManager.getHintString());
    }

    @Test
    void getHint_볼_스트라이크_테스트() {
        StringBuilder ballStrike = new StringBuilder();
        ballStrike.append(answer.charAt(0));
        for (int i = answer.length() - 1; i > 0; i--) {
            ballStrike.append(answer.charAt(i));
        }
        NumberManager.getHint(ballStrike.toString());

        assertThat("2볼 1스트라이크").isEqualTo(GameManager.getHintString());
    }

    @Test
    void getHint_낫싱_테스트() {
        StringBuilder nothing = new StringBuilder();
        for (int i = 0; i < answer.length(); i++) {
            nothing.append((answer.charAt(i) + 1) % 9 + 1);
        }
        NumberManager.getHint(nothing.toString());

        assertThat("낫싱").isEqualTo(GameManager.getHintString());
    }

}
