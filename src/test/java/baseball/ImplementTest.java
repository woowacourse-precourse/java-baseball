package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.mockito.MockedStatic;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

public class ImplementTest extends NsTest{

    final ByteArrayOutputStream captor = new ByteArrayOutputStream();
    final PrintStream out = System.out;

    @BeforeEach
    void setOutput() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(out);
    }

    @Test
    void 정답_생성_테스트() {
        List<Integer> answer = GameManager.createAnswer();
        assertThat(answer.size()).isEqualTo(3);
        for(int element : answer) {
            assertThat(element)
                .isGreaterThan(0)
                .isLessThan(10);
        }
    }

    @Test
    @DisplayName("정답 여부에 따른 게임 종료여부 테스트")
    void isFinish_test() {
        int strike = 3;
        int ball = 1;
        assertThat(GameManager.isFinish(strike)).isEqualTo(true);
        assertThat(GameManager.isFinish(strike-ball)).isEqualTo(false);
    }

    @Tag("isAgain test")
    @Test
    @DisplayName("게임 종료후 재시작 테스트")
    void isAgain_true_test() {
        String restart = "1";
        InputStream in = new ByteArrayInputStream(restart.getBytes());
        System.setIn(in);
        assertThat(GameManager.isAgain(true)).isEqualTo(true);
    }

    @Tag("isAgain test")
    @Test
    @DisplayName("게임 종료후 종료 테스트")
    void isAgain_false_test() {
        String terminate = "2";
        InputStream in = new ByteArrayInputStream(terminate.getBytes());
        System.setIn(in);
        assertThat(GameManager.isAgain(true)).isEqualTo(false);
    }

    @Tag("isAgain test")
    @Test
    @DisplayName("게임 종료후 인풋 예외 테스트")
    void isAgain_exception_test() {
        String wrong_input = "rr";
        InputStream in = new ByteArrayInputStream(wrong_input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> GameManager.isAgain(true))
            .isInstanceOf(IllegalArgumentException.class
        );
    }

    @Test
    @DisplayName("게임중 유저입력 read 테스트")
    void whileRunning_test() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(1,3,5));
        String userInputString = "135";
        InputStream in = new ByteArrayInputStream(userInputString.getBytes());
        System.setIn(in);
        assertThat(Input.whileRunning()).isEqualTo(answer);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
