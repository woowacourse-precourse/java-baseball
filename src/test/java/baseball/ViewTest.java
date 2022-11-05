package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {

    @Test
    void 게임_시작메시지_출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        View.printStartGame();
        assertThat("숫자 야구 게임을 시작합니다.").isEqualTo(out.toString().trim());
    }

    @Test
    void 게임_종료_또는_새로시작메시지_출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        View.printChoiceEndOrNewGame();
        assertThat("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.").isEqualTo(out.toString().trim());
    }
    @Test
    void 숫자를_입력해주세요메시지_출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        View.printPleaseInputNumber();
        assertThat("숫자를 입력해주세요 : ").isEqualTo(out.toString());
    }
}
