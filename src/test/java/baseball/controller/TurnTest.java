package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Target;
import baseball.model.TurnScore;
import baseball.constant.ResultTurn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TurnTest {
    List<Integer> testTargetNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));
    Target testTarget = new Target(testTargetNumberList);

    @Nested
    @DisplayName("반복 여부 확인")
    class checkCanRepeat {

        @Test
        @DisplayName("1) 반복 가능 -> true 반환")
        void 반복_가능() {
            Turn turn = new Turn(testTarget);
            assertThat(turn.checkCanRepeat()).isEqualTo(true);
        }

        @Test
        @DisplayName("2) 반복 불가능 -> out 반환")
        void 반복_불가능() {
            TurnScore turnScore = new TurnScore(0, 3, ResultTurn.OUT);
            Turn turn = new Turn(testTarget, turnScore);
            assertThat(turn.checkCanRepeat()).isEqualTo(false);
        }
    }

    @Test
    @DisplayName("타겟과 입력 숫자의 같은 자리 수 중, 일치하는 개수 세기")
    void countSameValueInSameIndex() {
        Turn turn = new Turn(testTarget);
        List<Integer> testUserNumberOfList = new ArrayList<>(Arrays.asList(1, 2, 4));
        int result = turn.countSameValueInSameIndex(testTargetNumberList, testUserNumberOfList);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("입력 숫자 중, 타겟에도 포함되는 숫자의 개수 세기")
    void countValueContainTogether() {
        Turn turn = new Turn(testTarget);
        List<Integer> testUserNumberOfList = new ArrayList<>(Arrays.asList(3, 2, 5));
        int result = turn.countValueContainTogether(testTargetNumberList, testUserNumberOfList);
        assertThat(result).isEqualTo(2);
    }

    @Nested
    @DisplayName("두 수를 비교하여 같으면 1, 아니면 0을 반환")
    class returnOneIfSameOrZero {

        @Test
        @DisplayName("1) 두 수가 같은 경우 -> 1 반환")
        void 같은_경우() {
            Turn turn = new Turn(testTarget);
            int result = turn.returnOneIfSameOrZero(3, 3);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("2) 두 수가 다른 경우 -> 0 반환")
        void 다른_경우() {
            Turn turn = new Turn(testTarget);
            int result = turn.returnOneIfSameOrZero(3, 5);
            assertThat(result).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("리스트에 숫자가 포함되어 있으면 1, 아니면 0을 반환")
    class returnOneIfListContainNumber {

        @Test
        @DisplayName("1) 리스트에 숫자가 포함된 경우 -> 1 반환")
        void 포함된_경우() {
            Turn turn = new Turn(testTarget);
            List<Integer> listForTestIsContainNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
            int result = turn.returnOneIfListContainNumber(listForTestIsContainNumber, 3);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("2) 리스트에 숫자가 포함되지 않은 경우 -> 0 반환")
        void 포함되지_않은_경우() {
            Turn turn = new Turn(testTarget);
            List<Integer> listForTestIsContainNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
            int result = turn.returnOneIfListContainNumber(listForTestIsContainNumber, 4);
            assertThat(result).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("숫자로 된 문자열을 리스트로 변환")
    void convertNumberStringToList() {
        Turn turn = new Turn(testTarget);
        String numberOfString = "123";
        assertThat(turn.convertNumberStringToList(numberOfString).get(0)).isEqualTo(1);
    }
}
