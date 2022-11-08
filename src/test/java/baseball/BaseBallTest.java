package baseball;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
