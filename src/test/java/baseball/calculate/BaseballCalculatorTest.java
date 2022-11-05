package baseball.calculate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[BaseballCalculator 클래스 테스트]")
class BaseballCalculatorTest {

    BaseballCalculator bc = new BaseballCalculator();

    public LinkedHashSet<Character> stringToLinkedHashSet(String s) {
        LinkedHashSet<Character> answer = new LinkedHashSet<>();
        for (int i=0; i<6; i+=2) {
            answer.add(s.charAt(i));
        }
        return answer;
    }

    @DisplayName("단위 메소드 테스트")
    @Nested
    class Test1 {

        @ParameterizedTest
        @DisplayName("strikeJudgement 메소드가 잘 실행되는가?")
        @CsvSource(value={"1,3,5:2,1,6:0","1,2,3:1,2,9:2","1,2,3:1,2,3:3"}, delimiter=':')
        void strikeJudgementTest(String inputNum, String currentNum, String expectedValue) {

            LinkedHashSet<Character> input = stringToLinkedHashSet(inputNum);
            LinkedHashSet<Character> output = stringToLinkedHashSet(currentNum);

            int n = bc.strikeJudgement(input, output);
            assertEquals(n, Integer.parseInt(expectedValue));
        }

        @ParameterizedTest
        @DisplayName("strikeJudgement 메소드가 잘 실행되는가?")
        @CsvSource(value={"1,2,3:2,3,1:3","1,2,3:1,2,3:0","1,2,3:2,1,3:2"}, delimiter=':')
        void ballJudgementTest(String inputNum, String currentNum, String expectedValue) {

            LinkedHashSet<Character> input = stringToLinkedHashSet(inputNum);
            LinkedHashSet<Character> output = stringToLinkedHashSet(currentNum);

            int n = bc.ballJudgement(input, output);
            assertEquals(n, Integer.parseInt(expectedValue));
        }
    }

}