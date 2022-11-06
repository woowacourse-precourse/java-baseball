package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameUtilsTest {

    @DisplayName("입력받은 문자열을 정수 리스트로 반환할 수 있다.")
    @Test
    void 사용자_입력() {
        System.setIn(generateUserInput("135"));
        List<Integer> input = GameUtils.getPlayerInputNum();
        assertThat(input).isEqualTo(Arrays.asList(1,3,5));
    }

    @DisplayName("중복되지 않는 세자리 정답을 랜덤으로 생성할 수 있다.")
    @Test
    void 난수_생성() {
        List<Integer> answer = GameUtils.getComputerAnswerNum();
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.stream().distinct().count()).isEqualTo(3);
    }

    @DisplayName("두 숫자에 대한 스트라이크 개수를 반환한다.")
    @Test
    void 스트라이크_개수_반환() {
        List<Integer> answerNum1 = List.of(1, 2, 3);
        List<Integer> playerNum1 = List.of(4, 2, 3);
        int strike1 = GameUtils.checkStrikeAndUpdateScore(answerNum1, playerNum1);
        assertThat(strike1).isEqualTo(2);

        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(3, 4, 1);
        int strike2 = GameUtils.checkStrikeAndUpdateScore(answerNum2, playerNum2);
        assertThat(strike2).isEqualTo(0);
    }

    @DisplayName("두 숫자에 대한 볼 개수를 반환한다.")
    @Test
    void 볼_개수_반환() {
        List<Integer> answerNum1 = List.of(1, 2, 3);
        List<Integer> playerNum1 = List.of(4, 1, 5);
        int ball1 = GameUtils.checkBallAndUpdateScore(answerNum1, playerNum1);
        assertThat(ball1).isEqualTo(1);

        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(3, 2, 1);
        int ball2 = GameUtils.checkBallAndUpdateScore(answerNum2, playerNum2);
        assertThat(ball2).isEqualTo(2);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
