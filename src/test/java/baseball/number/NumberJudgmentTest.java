package baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberJudgmentTest {

    @Test
    @DisplayName("같은 숫자가 몇 개인지 테스트")
    void getSameNumberCountMethodTest() {
        // given
        List<Integer> computerNumberList = List.of(3, 5, 6);
        List<Integer> userNumberList = List.of(5, 3, 1);
        NumberJudgment numberJudgment = new NumberJudgment();

        // when
        int sameNumberCount = numberJudgment.getSameNumberCount(computerNumberList, userNumberList);

        // then
        assertEquals(sameNumberCount, 2);
    }

    @Test
    @DisplayName("같은 숫자 중에 같은 인덱스가 몇 개인지 테스트")
    void getSameIndexCountMethodTest() {
        // given
        List<Integer> computerNumberList = List.of(3, 8, 7);
        List<Integer> userNumberList = List.of(3, 2, 8);
        NumberJudgment numberJudgment = new NumberJudgment();
        numberJudgment.getSameNumberCount(computerNumberList, userNumberList);

        // when
        int sameIndexCount = numberJudgment.getSameIndexCount(userNumberList);

        //then
        assertEquals(sameIndexCount, 1);
    }
}
