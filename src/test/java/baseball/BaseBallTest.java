package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {
    private static BaseBall test;
    @BeforeEach
    public void beforeEach(){
        test = new BaseBall();
    }
    @Test
    public void helloMessageTest() throws Exception {
        //given
        String input = "숫자 야구 게임을 시작합니다.";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        test.helloMessage();
        //expect
        assertThat(input).isEqualTo(out.toString().trim());
    }
}