package baseball;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.Application.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest extends NsTest {


    @Test
    @DisplayName("야구게임 시작 메세지 출력하기")
    void printBaseballGameMessage(){
        String displayMessage = "숫자 야구 게임을 시작합니다.";
        baseballGameStart();
        assertThat(output()).isEqualTo(displayMessage);
    }

    @Test
    @DisplayName("컴퓨터의 수가 랜덤하게 출럭하기")
    void craeteRandomNumbers(){
        String num1 = randomNumberCreate().toString();
        String num2 = randomNumberCreate().toString();
        assertThat(num1).isNotEqualTo(num2);
    }

    @Test
    @DisplayName("사용자의 숫자 를물어는 함수")
    void printUserNumberMessage(){
        String printMessage = "숫자를 입력하세요 :";
        userNumberMessagePrint();
        assertThat(output()).isEqualTo(printMessage);
    }

    @Test
    @DisplayName("컴퓨터의 수와 사용자의 수의 strike 갯수를 구하기")
    void checkStrikeNumbersTest(){
        List<Integer> computerNumbers = List.of(2,3,4);
        List<Integer> userNumbers = List.of(2,5,4);
        int strikeOfNumbers = checkStrikeNumbers(computerNumbers,userNumbers);

        assertThat(strikeOfNumbers).isEqualTo(2);
    }

    @Test
    @DisplayName("컴퓨터의 수와 사용자의 수의 ball 갯수를 구하기")
    void checkedBallNumbersTest(){
        List<Integer> computerNumbers = List.of(2,3,9);
        List<Integer> userNumbers = List.of(7,6,2);
        int ballOfNumbers = checkedBallNumbers(computerNumbers,userNumbers);

        assertThat(ballOfNumbers).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크와 볼의 정확한 갯수 구하기")
    void calculatedStrikeBallNumberTest(){
        Map<String,Integer> checkedBaseballNumbers = calculatedStrikeBallNumber(2,3);
        Map<String, Integer> result = new HashMap<>(){{
            put("strike",2);
            put("ball",1);
        }};

        assertThat(checkedBaseballNumbers).isEqualTo(result);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
