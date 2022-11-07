package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static baseball.util.NumberUtil.*;

public class NumberUtilTest {
    @DisplayName("컴퓨터의 정답 생성 기능 테스트")
    @Test
    void checkRandomThreeNumberTest() {
        List<Integer> numberList = createRandomNumber();

        assertThat(numberList.size()).isEqualTo(3);
        assertThat(numberList.get(0)).isGreaterThan(0).isLessThan(10);
        assertThat(numberList.get(1)).isGreaterThan(0).isLessThan(10);
        assertThat(numberList.get(2)).isGreaterThan(0).isLessThan(10);
        for (int index = 0; index < numberList.size() - 1; index++) {
            for (int compareIndex = index + 1; compareIndex < numberList.size(); compareIndex++)
                assertThat(numberList.get(index)).isNotEqualTo(numberList.get(compareIndex));
        }
    }

    @DisplayName("사용자 숫자 입력 예외사항 판단 기능 테스트")
    @Test
    void checkInputNumberTest() {
        String failureInput1 = "1234";
        String failureInput2 = "098";
        String failureInput3 = "1 3";
        String failureInput4 = "-89";
        String failureInput5 = "f56";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(failureInput1);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(failureInput2);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(failureInput3);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(failureInput4);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(failureInput5);
        });
    }

    @DisplayName("힌트를 판단하고 화면에 출력하는 기능 테스트")
    @Test
    void chechHintTest() {
        List<Integer> answerList1 = List.of(1, 2, 3);
        List<Integer> userList1 = List.of(1, 2, 3);

        List<Integer> answerList2 = List.of(1, 2, 3);
        List<Integer> userList2 = List.of(3, 2, 1);

        assertThat(isCorrect(answerList1, userList1)).isTrue();
        assertThat(isCorrect(answerList2, userList2)).isFalse();
    }

    @DisplayName("문자열을 숫자로 바꾸는 메서드 예외 처리 테스트")
    @Test
    void checkRestart() {
        String answer1 = "a";
        String answer2 = "@";
        String answer3 = "@TEST_123";

        assertThatIllegalArgumentException().isThrownBy(() -> {
           toInteger(answer1);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            toInteger(answer2);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            toInteger(answer3);
        });
    }
}
