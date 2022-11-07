package baseball.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class ViewTest {

    @Test
    void 입력값에_대한_결과를_출력하는_기능 () throws Exception {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        View.resultView(2, 1);

        //then
        assertThat(out.toString().trim()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 게임_성공시_성공_멘트_출력하는_기능 () throws Exception {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int length = 3;

        //when
        View.completeView(length);

        //then
        assertThat(out.toString().trim()).isEqualTo(length + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
