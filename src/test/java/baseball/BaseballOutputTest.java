package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BaseballOutputTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }


    @Test
    void 게임_시작_메세지를_출력한다() {
        BaseballOutput.printGameStart();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 게임_코드_입력_메세지를_출력한다() {
        BaseballOutput.printInputPlayCodeMessage();
        assertThat(output()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Test
    void 숫자_입력_메세지를_출력한다() {
        BaseballOutput.printInputNumberMessage();
        assertThat(output()).isEqualTo("숫자를 입력해주세요 : ".trim());
    }


}
