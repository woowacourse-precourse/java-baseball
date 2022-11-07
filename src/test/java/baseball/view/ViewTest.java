package baseball.view;

import org.junit.jupiter.api.Test;

import java.io.*;

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

    @Test
    void 게임_중_유저에게_입력받는_기능 () throws Exception {
        //given
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when

        //then
        assertThat(View.inputView()).isEqualTo(input);
    }

    @Test
    void 재시작_종료를_구분하는_입력을_받는_기능 () throws Exception {
        //given
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when

        //then
        assertThat(View.endView()).isEqualTo(input);
    }
}
