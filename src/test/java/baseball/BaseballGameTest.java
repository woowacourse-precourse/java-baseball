package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void inputHumanNumberTest(){
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