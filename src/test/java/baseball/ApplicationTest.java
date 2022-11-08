package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    static String ANSWER1 = "123";
    static String ANSWER2 = "456";
    static int[] ANSWER1_ARR = Arrays.stream(ANSWER1.split("")).mapToInt(Integer::parseInt).toArray();
    static int[] ANSWER2_ARR = Arrays.stream(ANSWER2.split("")).mapToInt(Integer::parseInt).toArray();

    static String RESTART_GAME = "1";
    static String END_GAME = "2";

    static final String GAME_GET_NUMBER = "숫자를 입력해주세요 : ";
    static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    static final String GAME_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String GAME_CORRECT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    List<String> onlyResult(String input) {
        input = input.replace("\r", "");
        input = input.replace(GAME_START, "");
        input = input.replace(GAME_CORRECT_ANSWER, "");
        input = input.replace(GAME_GET_NUMBER, "");
        input = input.replace(GAME_RESTART_OR_END, "");
        input = input.replace(" ", "");
        List<String> result = new ArrayList<>(List.of(input.split("\n")));
        result.remove("");
        return result;
    }

    @DisplayName("Basic: 게임 진행, 재시작, 종료")
    @Test
    void basic() {
        String[] inputs = {"987", ANSWER1, RESTART_GAME, "485", ANSWER2, END_GAME};
        assertRandomNumberInRangeTest(
                () -> {
                    run(inputs);
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                ANSWER1_ARR[0], ANSWER1_ARR[1],ANSWER1_ARR[2],ANSWER2_ARR[0],ANSWER2_ARR[1],ANSWER2_ARR[2]
                );
    }

    @DisplayName("Basic: 볼 갯수 세기")
    @Test
    void inGameCountBall() {
        String[] inputs = {"312", "234", "345", ANSWER1, END_GAME};
        assertRandomNumberInRangeTest(
                () -> run(inputs),
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(onlyResult(output())).containsExactly("3볼", "2볼", "1볼", "3스트라이크");
    }

    @DisplayName("Basic: 스트라이크 갯수 세기")
    @Test
    void inGameCountStrike() {
        String[] inputs = {"145", "124", "123", END_GAME};
        assertRandomNumberInRangeTest(
                () -> run(inputs),
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(onlyResult(output())).containsExactly("1스트라이크", "2스트라이크", "3스트라이크");
    }

    @DisplayName("Basic: 매치되지 않음 -> 낫싱")
    @Test
    void inGameNothing() {
        String[] inputs = {"456", ANSWER1, END_GAME};
        assertRandomNumberInRangeTest(
                () -> run(inputs),
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(onlyResult(output())).containsExactly("낫싱", "3스트라이크");
    }

    @DisplayName("Basic: 정답을 맞췄을 때")
    @Test
    void inGameRightAnswer() {
        String[] inputs = {ANSWER1, END_GAME};
        assertRandomNumberInRangeTest(
                () -> run(inputs),
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(onlyResult(output())).containsExactly("3스트라이크");
    }

    @DisplayName("Print: 기본 게임 진행 문구 출력")
    @Test
    void printProgressStatements() {
        String[] inputs = {ANSWER1, END_GAME};
        assertRandomNumberInRangeTest(
                () -> run(inputs),
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(output()).contains(
                GAME_START,
                GAME_GET_NUMBER,
                GAME_CORRECT_ANSWER,
                GAME_RESTART_OR_END);
    }



    @DisplayName("Exception: inGame에서 숫자 네 개 입력")
    @Test
    void exception4number() {
        String notValidInput = "1234";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(notValidInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @DisplayName("Exception: inGame에서 숫자가 아닌 입력")
    @Test
    void exceptionNotNumberInGame() {
        String notValidInput = "num";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(notValidInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @DisplayName("Exception: inGame에서 0이 포함된 입력")
    @Test
    void exceptionContainsZero() {
        String notValidInput = "103";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(notValidInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("Exception: inGame에서 중복된 숫자 입력")
    @Test
    void exceptionRepetition() {
        String notValidInput = "113";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(notValidInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("Exception: endGame에서 1이나 2가 아닌 숫자")
    @Test
    void exceptionNot1or2() {
        String notValidInput = "3";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        assertRandomNumberInRangeTest(
                                () -> run(ANSWER1, notValidInput),
                                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
                        ))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("Exception: endGame에서 숫자가 아닌 입력")
    @Test
    void exceptionNotNumberEndGame() {
        String notValidInput = "X";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        assertRandomNumberInRangeTest(
                                () -> run(ANSWER1, notValidInput),
                                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
                        ))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
