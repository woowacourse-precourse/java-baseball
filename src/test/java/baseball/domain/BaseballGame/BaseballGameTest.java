package baseball.domain.BaseballGame;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Hint.HintString;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
    private BaseballGame baseballGame;
    private Method checkGameEnd;
    private Field isPlaying;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
        try {
            checkGameEnd = baseballGame.getClass().getDeclaredMethod("checkPlayerWin", String.class);
            checkGameEnd.setAccessible(true);
        } catch (NoSuchMethodException exception) {
            System.out.println("BaseballGameTest -> checkPlayerWin Method reflection error");
        }

        try {
            isPlaying = baseballGame.getClass().getDeclaredField("isPlaying");
            isPlaying.setAccessible(true);
        } catch (NoSuchFieldException exception) {
            System.out.print("BaseballGameTest -> isPlaying variable reflection error");
        }
    }

    @Test
    @DisplayName("힌트가 3스트라이크일 때 게임 종료를 테스트한다")
    void 힌트가_3스트라이크일때_게임_종료() throws InvocationTargetException, IllegalAccessException {
        String hintString = HintString.STRIKE.print(3);
        boolean result = false;

        checkGameEnd.invoke(baseballGame, hintString);

        assertThat(isPlaying.getBoolean(baseballGame)).isEqualTo(result);
    }

    @Test
    @DisplayName("힌트가 스트라이크 볼일 때 게임 종료를 테스트한다")
    void 힌트가_스트라이크가_아닐_때_게임_지속() throws InvocationTargetException, IllegalAccessException {
        String hintString = HintString.BALL.print(1) + HintString.STRIKE.print(2);
        boolean result = true;

        checkGameEnd.invoke(baseballGame, hintString);

        assertThat(isPlaying.getBoolean(baseballGame)).isEqualTo(result);
    }
}
