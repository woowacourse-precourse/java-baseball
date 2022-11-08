package game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GamePlayTest {

    @Test
    void getAnswer_값들이_1과9사이숫자인지_검증() {
        List<Integer> range = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> answer = GamePlay.getAnswer();
        System.out.println(answer);
        for (int ans : answer) {
            assertThat(range).contains(ans);
        }
    }

    @Test
    void judgeBallOrStrike_ball과Strike_올바른지_검증() {


    }

    @Test
    void printHintMessage() {
    }

    @Test
    void provideHintMessage_힌트메시지_출력과_정답여부반환_검증() {
        List<Integer> temporaryAnswer = List.of(8, 7, 4);
        List<Integer> temporaryUserAnswer = List.of(1, 2, 3);
        assertThat(GamePlay.provideHintMessage(temporaryAnswer,temporaryUserAnswer)).isFalse();
    }
}