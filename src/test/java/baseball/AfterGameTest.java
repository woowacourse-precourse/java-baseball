package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AfterGameTest {
    private static AfterGame after;
    @BeforeEach
    public void beforeEach(){
        after = new AfterGame();
    }
    @Test
    public void outputQuestTest() throws Exception {
        //given
        String input = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        after.outputQuest();
        //expect
        assertThat(input).isEqualTo(out.toString().trim());
    }
    @Test
    public void isRestartOrFinishTest() throws Exception{
        //expect
        assertThat(after.isRestartOrFinish("1")).isEqualTo(true);
        assertThat(after.isRestartOrFinish("2")).isEqualTo(false);
        assertThrows(IllegalArgumentException.class, ()->after.isRestartOrFinish("3"));

    }
}