package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.utils.UserInputAdapter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void 객체_생성시_멤버변수_확인() {
        //given
        Game testGame = new Game();

        //when
        boolean running = testGame.isRunning();

        //then
        Assertions.assertThat(running).isEqualTo(false);
    }

    @Test
    void startRound_메서드_실행시_running_true로_변경() {
        //given
        Game testGame = new Game();

        //when
        testGame.startRound();
        boolean running = testGame.isRunning();

        //then
        Assertions.assertThat(running).isEqualTo(true);
    }

    @Test
    void getUserInput_메서드_실행시_유효하지_않은_입력값에_대한_예외_발생() {
        //given
        Game testGame = new Game();
        String testString = "1234";
        String lengthErrorMessage = "숫자는 세 자리 수여야 합니다.";
        InputStream in = new ByteArrayInputStream(testString.getBytes());
        System.setIn(in);

        //when,then
        assertThatThrownBy(testGame::getUserInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(lengthErrorMessage);
    }

    @Test
    void getUserInput_메서드_실행시_배열_반환() {
        //given
        Game testGame = new Game();
        String testString = "123";
        InputStream in = new ByteArrayInputStream(testString.getBytes());
        System.setIn(in);

        //when
        List<Integer> testArray = testGame.getUserInput();

        // then
        Assertions.assertThat(testArray).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void decideRestart_메서드_실행시_알맞는_restartSign_반환_확인() {
        //given
        Game testGame = new Game();
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        //when
        boolean restart = testGame.decideRestart();

        //then
        assertThat(restart).isEqualTo(true);
    }
}
