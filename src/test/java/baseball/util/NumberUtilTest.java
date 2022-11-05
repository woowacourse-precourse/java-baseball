package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static baseball.util.NumberUtil.*;

public class NumberUtilTest {
    @DisplayName("컴퓨터의 정답 생성 기능 테스트")
    @Test
    public void checkRandomThreeNumberTest() {
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
    public void checkInputNumberTest() {
        String input_failure1 = "1234";
        String input_failure2 = "098";
        String input_failure3 = "1 3";
        String input_failure4 = "-89";
        String input_failure5 = "f56";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(input_failure1);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(input_failure2);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(input_failure3);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(input_failure4);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            checkInputException(input_failure5);
        });
    }

    @DisplayName("힌트를 판단하고 화면에 출력하는 기능 테스트")
    @Test
    public void chechHintTest() {
        List<Integer> answerList1 = List.of(1, 2, 3);
        List<Integer> userList1 = List.of(1, 2, 3);

        List<Integer> answerList2 = List.of(1, 2, 3);
        List<Integer> userList2 = List.of(3, 2, 1);

        assertThat(isCorrect(answerList1, userList1)).isTrue();
        assertThat(isCorrect(answerList2, userList2)).isFalse();
    }
}
