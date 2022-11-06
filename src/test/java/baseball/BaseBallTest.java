package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static baseball.Application.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    @DisplayName("야구게임 시작 메세지 출력하기")
    void printBaseballGameMessage(){
        System.setOut(new PrintStream(output));

        String displayMessage = "숫자 야구 게임을 시작합니다.\n";
        baseballGameStart();
        assertThat(output.toString()).isEqualTo(displayMessage);

        System.setOut(System.out);
        output.reset();
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
        System.setOut(new PrintStream(output));

        String printMessage = "숫자를 입력하세요 : ";
        userNumberMessagePrint();
        assertThat(output.toString()).isEqualTo(printMessage);

        System.setOut(System.out);
        output.reset();
    }
}
