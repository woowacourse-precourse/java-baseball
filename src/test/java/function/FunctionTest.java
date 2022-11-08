package function;

import baseball.*;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionTest extends NsTest {

    @Test
    void userInput_기능_테스트() {
        String wrongUserNumber1  = "1234";
        String wrongUserNumber2  = "abc";
        String wrongUserNumber3  = "111";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(wrongUserNumber1))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(wrongUserNumber2))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(wrongUserNumber3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void BaseBallGameAndGameContinue_기능_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "3", "1", "748", "789", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크","입력하세요", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                4, 5, 6, 7, 8, 9
        );
    }

    @Test
    void CollectResult_기능_테스트(){
        List<List<Integer>> userNumbersTest = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(3,1,2),
                Arrays.asList(1,4,2)
        );
        List<List<Integer>> testResult = Arrays.asList(
                Arrays.asList(3,0),
                Arrays.asList(0,0),
                Arrays.asList(0,3),
                Arrays.asList(1,1)
        );
        List<Integer> computerNumberTest = Arrays.asList(1,2,3);

        for(int i=0; i<userNumbersTest.size(); i++){
            List<Integer> result = CollectResult.compareUserComputer(
                    userNumbersTest.get(i), computerNumberTest);

            assertThat(testResult.get(i)).isEqualTo(result);
        }
    }

    @Test
    void ComputerNumber_기능_테스트(){
        List<Integer> computerNumberTest = ComputerNumber.randomNumber();
        int randomNumber1 = computerNumberTest.get(0);
        int randomNumber2 = computerNumberTest.get(1);
        int randomNumber3 = computerNumberTest.get(2);

        assertThat(3).isEqualTo(computerNumberTest.size());

        assertThat(false).isEqualTo(randomNumber1 == randomNumber2);
        assertThat(false).isEqualTo(randomNumber1 == randomNumber3);
        assertThat(false).isEqualTo(randomNumber2 == randomNumber3);
    }

    @Test
    void ResultOutput_기능_테스트(){
        List<List<Integer>> ResultOutputTest = Arrays.asList(
                Arrays.asList(0,0),
                Arrays.asList(3,0),
                Arrays.asList(0,3),
                Arrays.asList(1,2)
        );
        List<String> resultString = Arrays.asList("낫싱","3스트라이크","3볼","2볼 1스트라이크");
        for(int i = 0; i<ResultOutputTest.size(); i++){
            assertThat(resultString.get(i)).isEqualTo(
             ResultOutput.resultString(ResultOutputTest.get(i)));
        }

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
