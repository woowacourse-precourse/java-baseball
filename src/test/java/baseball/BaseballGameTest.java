package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

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