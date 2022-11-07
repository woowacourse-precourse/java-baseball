package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.Referee;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {

    private InputView inputView = new InputView();
    private Referee referee = new Referee();

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
    void 예외_테스트_한글입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("가나다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    private void mockIO(String input){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}

