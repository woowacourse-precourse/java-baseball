package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static baseball.Application.baseballGameStart;
import static baseball.Application.randomNumberCreate;
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
    @DisplayName("컴퓨터의 수가 랜덤하게 출럭되는지 테스")
    void craeteRandomNumbers(){
        String num1 = randomNumberCreate().toString();
        String num2 = randomNumberCreate().toString();
        System.out.println( "num1 : "+num1+", num2 : "+num2);
        assertThat(num1).isNotEqualTo(num2);
    }
}
