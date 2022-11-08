package baseball;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest{
    private static Player player;

    @BeforeAll
    static void init(){
        player = new Player();
    }

    private void setIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void 정상_숫자_입력_테스트(){
        String input = "123";
        setIn(input);

        String ret = player.getNumberInput();
        assertThat(ret).isEqualTo(input);
    }

    @Test
    void 재시작_입력_테스트(){
        String input = "1";
        setIn(input);

        boolean ret = player.getRestartOrQuitInput();
        assertThat(ret).isTrue();
    }

    @Test
    void 종료_입력_테스트(){
        String input = "2";
        setIn(input);

        boolean ret = player.getRestartOrQuitInput();
        assertThat(ret).isFalse();
    }
}
