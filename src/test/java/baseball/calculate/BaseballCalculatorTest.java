package baseball.calculate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

class BaseballCalculatorTest {

    final BaseballCalculator bc = new BaseballCalculator();

    public LinkedHashSet<Character> stringToLinkedHashSet(String s) {
        var answer = new LinkedHashSet<Character>();
        for (int i=0; i<6; i+=2) {
            answer.add(s.charAt(i));
        }
        return answer;
    }

    @Nested
    class Test1 {

        @ParameterizedTest
        @CsvSource(value={"1,3,5:2,1,6:0","1,2,3:1,2,9:2","1,2,3:1,3,7:1"}, delimiter=':')
        void strikeJudgementTest(
                final String inputNum,
                final String currentNum,
                final String expectedValue
        ) {
            var input = stringToLinkedHashSet(inputNum);
            var output = stringToLinkedHashSet(currentNum);

            int n = bc.strikeJudgement(input, output);
            assertEquals(n, Integer.parseInt(expectedValue));
        }

        @ParameterizedTest
        @CsvSource(value={"1,2,3:2,3,1:3","1,2,3:1,2,3:0","1,2,3:1,3,7:1"}, delimiter=':')
        void ballJudgementTest(
                final String inputNum,
                final String currentNum,
                final String expectedValue
        ) {

            var input = stringToLinkedHashSet(inputNum);
            var output = stringToLinkedHashSet(currentNum);

            int n = bc.ballJudgement(input, output);
            assertEquals(n, Integer.parseInt(expectedValue));
        }
    }

}