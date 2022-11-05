package baseball;

import baseball.domain.Referee;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private InputView inputView = new InputView();
    private Referee referee = new Referee();

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 단일값_테스트(){
        String input = "1";
        mockIO(input);

        int result = inputView.inputNumber();
        assertThat(Integer.parseInt(input)).isEqualTo(result);
    }

    @Test
    void 다중값_테스트(){
        String input = "123";
        mockIO(input);

        List<Integer> list = inputView.inputNumbers();
        assertThat(input.length()).isEqualTo(list.size());
    }

    @Test
    void 랜덤값_생성_테스트(){
        List<Integer> list = referee.makeRandomValues();
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private void mockIO(String input){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
