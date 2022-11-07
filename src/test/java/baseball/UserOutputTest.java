package baseball;

import baseball.utils.UserOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static baseball.utils.BaseballConstants.*;
import static org.assertj.core.api.Assertions.*;

public class UserOutputTest {

    private OutputStream outputStream;

    @BeforeEach
    void init(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "1, 0", "0, 0", "3, 0", "2, 1", "1, 2", "0, 3"})
    void 볼_스트라이크_카운트_출력_확인(Integer ball, Integer strike){
        UserOutput.printResult(ball, strike);
        if (strike == BALL_NUMBER){
            assertThat(outputStream.toString()).isEqualTo("3스트라이크\n" + GAME_OVER+'\n');
        }
        else if (strike == 0 && ball == 0){
            assertThat(outputStream.toString()).isEqualTo("낫싱\n");
        }
        else if (strike == 0){
            assertThat(outputStream.toString()).isEqualTo(ball+"볼\n");
        }
        else if (ball == 0){
            assertThat(outputStream.toString()).isEqualTo(strike+"스트라이크\n");
        }
        else{
            assertThat(outputStream.toString()).isEqualTo(ball+"볼 "+ strike+"스트라이크\n");
        }
    }
}
