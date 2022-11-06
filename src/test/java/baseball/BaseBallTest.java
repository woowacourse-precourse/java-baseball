package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static baseball.Application.baseballGameStart;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
        output.reset();
    }
    @Test
    @DisplayName("야구게임 시작 메세지 출력하기")
    void printBaseballGameMessage(){
        String displayMessage = "숫자 야구 게임을 시작합니다.\n";
        baseballGameStart();
        assertThat(output.toString()).isEqualTo(displayMessage);
    }
}
