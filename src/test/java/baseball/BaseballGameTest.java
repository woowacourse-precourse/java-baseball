package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballGameTest {
    BaseballGame bg = new BaseballGame();

    @Test
    @DisplayName("초기화 중복 검사 테스트")
    void initAnswerNumberTest() {

        boolean check = true;
        List<Integer> answer = bg.initAnswerNumber();
        for (int i = 0; i < 100000; i++) {

            check = overlapTest(answer, true);
            if (!check) {
                break;
            }
            answer = bg.initAnswerNumber();
        }
        assertTrue(check);
    }

    @Test
    @DisplayName("사용자 입력 테스트")
    void inputHumanNumberTest() {
        List<Integer> human = bg.inputHumanNumber("123");
        assertEquals(Arrays.toString(new int[]{1, 2, 3}), human.toString());
    }

    @Test
    @DisplayName("사용자 입력 예외 테스트")
    void inputHumanExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> bg.inputHumanNumber("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> bg.inputHumanNumber("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> bg.inputHumanNumber("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("볼 확인")
    void checkBallCount() {
        ArrayList<Integer> human = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> computuer = new ArrayList<>(List.of(5, 3, 9));
        assertEquals(1, bg.returnBallCount(human, computuer));

        human = new ArrayList<>(List.of(1, 2, 3));
        computuer = new ArrayList<>(List.of(5, 3, 1));
        assertEquals(2, bg.returnBallCount(human, computuer));

        human = new ArrayList<>(List.of(1, 2, 3));
        computuer = new ArrayList<>(List.of(2, 3, 1));
        assertEquals(3, bg.returnBallCount(human, computuer));

        human = new ArrayList<>(List.of(1, 2, 3));
        computuer = new ArrayList<>(List.of(4, 5, 6));
        assertEquals(0, bg.returnBallCount(human, computuer));
    }

    @Test
    @DisplayName("스트라이크 확인")
    void checkStrikeCount() {
        ArrayList<Integer> human = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> computuer = new ArrayList<>(List.of(1, 3, 9));
        assertEquals(1, bg.returnStrike(human, computuer));

        human = new ArrayList<>(List.of(1, 2, 3));
        computuer = new ArrayList<>(List.of(1, 2, 5));
        assertEquals(2, bg.returnStrike(human, computuer));

        human = new ArrayList<>(List.of(1, 2, 3));
        computuer = new ArrayList<>(List.of(1, 2, 3));
        assertEquals(3, bg.returnStrike(human, computuer));

        human = new ArrayList<>(List.of(1, 2, 3));
        computuer = new ArrayList<>(List.of(4, 5, 6));
        assertEquals(0, bg.returnStrike(human, computuer));
    }


    public boolean overlapTest(List<Integer> answer, boolean check) {

        for (int i = 1; i < answer.size(); i++) {
            check = checkBooleanOverlapTest(answer, i);
            if (!check) {
                return false;
            }
        }
        return check;
    }

    public boolean checkBooleanOverlapTest(List<Integer> answer, int i) {
        for (int j = 0; j < i - 1; j++) {
            if (Objects.equals(answer.get(i), answer.get(j))) {
                return false;
            }
        }
        return true;
    }


}