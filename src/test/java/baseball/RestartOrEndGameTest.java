package baseball;

import baseball.exception.GameException;
import baseball.gameComponents.GameComponent;
import baseball.gameComponents.Validator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class RestartOrEndGameTest {
    private Validator validator = new Validator();
    private GameComponent gameComponent = new GameComponent(validator);
    @Test
    void 예외_테스트() {
        //given
        String input = "f1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        Throwable throwable = catchThrowable(() -> {
            boolean isReStart = restartOrEndGame();
        });
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }
    @Test
    void 새로시작_테스트() {
        //given
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        boolean isReStart = restartOrEndGame();

        //then
        assertThat(isReStart)
                .isEqualTo(true);
    }
    @Test
    void 종료_테스트() {
        //given
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        boolean isReStart = restartOrEndGame();

        //then
        assertThat(isReStart)
                .isEqualTo(false);
    }

    public boolean restartOrEndGame() {
        return gameComponent.restartOrEndGame();
    }
}
