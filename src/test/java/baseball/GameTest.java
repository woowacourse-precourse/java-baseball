package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class GameTest {

    static MockedStatic<Randoms> randomsMockedStatic;

    @BeforeAll
    static void beforeAll() {
        randomsMockedStatic = mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(1,9)).thenReturn(1,2,3);
    }

    @AfterAll
    static void afterAll() {
        randomsMockedStatic.close();
    }

    @DisplayName(value = "게임 재시작 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false"})
    void restartTest(String input, boolean isReplay) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Game game = new Game();
        boolean replayGame = game.replayGame();

        assertThat(replayGame).isEqualTo(isReplay);
    }

    @DisplayName(value = "게임 재시작 입력 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "0"})
    void restartExceptionTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Game game = new Game();

        assertThatThrownBy(() -> game.replayGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "3개 다 맞출 시 출력 테스트")
    @Test
    void winPrintTest() {
        String input = "123";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Game game = new Game();
        Computer computer = new Computer();
        User user = new User();
        game.turnOnGame(computer, user);
        game.startNewGame();

        assertThat(out.toString().trim())
                .isEqualTo("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 : 3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
