package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballGameHintTest extends NsTest {

    public void runMain() {}

    @Test
    @DisplayName("스트라이크와 볼 출력")
    void getHintStrikeAndBall(){
        String resultOutput="1볼 1스트라이크";
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(2, 1, 3);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("스트라이크만 출력")
    void getHintOnlyStrike(){
        String resultOutput="2스트라이크";
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(2, 3, 4);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("볼만 출력")
    void getHintOnlyBall(){
        String resultOutput="2볼";
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(3, 2, 4);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("낫싱 출력")
    void getHintNothing(){
        String resultOutput="낫싱";
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(7, 8, 9);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("정답일때 true 반환")
    void isAnswerTrue(){
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(2, 3, 5);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertTrue(baseballGameHint.isAnswer());
    }

    @Test
    @DisplayName("정답이 아닐때 false 반환")
    void isAnswerFalse(){
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(2, 3, 1);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertFalse(baseballGameHint.isAnswer());
    }
}