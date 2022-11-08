package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameCalculatorTest {
    @Test
    void 테스트케이스() {
        //given
        BaseballNumber answer = BaseballNumber.createByUserInput("234");
        List<String> testUserInputList = List.of("123", "467", "259", "231", "234");
        List<BaseballGameResult> expectedResultList = List.of(new BaseballGameResult(2, 0)
                , new BaseballGameResult(1, 0), new BaseballGameResult(0, 1)
                , new BaseballGameResult(0, 2), new BaseballGameResult(0, 3));

        //when
        List<BaseballGameResult> calculateResultList = new ArrayList<>();
        for (String input : testUserInputList) {
            calculateResultList.add(
                    BaseballGameCalculator.calculateBallStrikeCount(BaseballNumber.createByUserInput(input), answer));
        }

        //then
        for (int i = 0; i < testUserInputList.size(); i++) {
            Assertions.assertThat(calculateResultList.get(i)).isEqualTo(expectedResultList.get(i));
        }
    }
}