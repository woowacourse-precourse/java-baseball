package baseball;

import baseball.UI.InputView;
import baseball.UI.ResultView;
import baseball.model.Hint;
import baseball.model.Input;
import baseball.model.Result;
import baseball.model.State;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void input_String_toIntList_Test(){
        String test = "123";
        List<Integer> testList = new Input(test).getBaseballNumberList();
        assertThat(testList).containsExactly(1, 2, 3);
    }

    @Test
    void inputView_test(){
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());;
        System.setIn(in);
        InputView inputView = new InputView();
        inputView.getBaseballInput();
        assertThat(inputView.getInput().getBaseballNumberList())
                .containsExactly(1, 2, 3);
    }

    @Test
    void hint_Model_ToString_Test(){
        int ball = 2;
        int strike = 1;
        Hint hint = new Hint(ball, strike);
        assertThat(hint.toString()).isEqualTo("2볼 1스트라이크\n");
    }
    @Test
    void resultView_FINISH_Test(){

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ResultView resultView = new ResultView();
        resultView.printResult(State.FINISH);
        assertThat(resultView.getResult()).isEqualTo(Result.FINISH);
    }
    @Test
    void resultView_Error_Test(){
        ResultView resultView = new ResultView();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> resultView.printResult(State.ERROR))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
