package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class GameViewTest {

    String printHint(int strike, int ball){

        //Console 에 출력되는 아웃풋을 바이트 아웃풋 스트림 out에 지정하여 저장한다.
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        BaseBallGameView.printHint(strike, ball);

        return out.toString();
    }

    @Test
    void caseOnlyStrike(){
        assertThat(printHint(2, 0)).isEqualTo("2스트라이크\n");
    }

    @Test
    void caseOnlyBall(){
        assertThat(printHint(0, 2)).isEqualTo("2볼\n");
    }

    @Test
    void caseStrikeBall(){
        assertThat(printHint(2, 1)).isEqualTo("1볼 2스트라이크\n");
    }

    @Test
    void caseNoStrikeNoBall(){
        assertThat(printHint(0, 0)).isEqualTo("낫싱\n");
    }
}
