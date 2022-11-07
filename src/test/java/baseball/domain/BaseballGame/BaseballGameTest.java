package baseball.domain.BaseballGame;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Hint.HintString;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
    private BaseballGame baseballGame;

    @Nested
    @DisplayName("플레이어의 힌트에 따른 게임 한 턴 종료를 테스트한다")
    class testGameEnd {
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
                System.out.println("BaseballGameTest -> isPlaying variable reflection error");
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

    @Nested
    @DisplayName("플레이어의 재시작 선택 시 새로운 게임 시작을 테스트한다")
    class testGameRestart {
        private Method checkGameRestart;
        private Field isStartRequested;

        @BeforeEach
        void setUp() {
            baseballGame = new BaseballGame();
            try {
                checkGameRestart = baseballGame.getClass().getDeclaredMethod("checkGameRestart");
                checkGameRestart.setAccessible(true);
            } catch (NoSuchMethodException exception) {
                System.out.println("BaseballGameTest -> checkGameRestart Method reflection error");
            }

            try {
                isStartRequested = baseballGame.getClass().getDeclaredField("isStartRequested");
                isStartRequested.setAccessible(true);
            } catch (NoSuchFieldException exception) {
                System.out.println("BaseballGameTest -> isStartRequested variable reflection error");
            }
        }

        @Test
        @DisplayName("플레이어가 재시작을 선택했을 때 시작 요청을 테스트한다")
        void 재시작_일_때_새_턴_시작() throws InvocationTargetException, IllegalAccessException {
            boolean result = true;
            String inputString = "1";

            InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
            System.setIn(inputStream);
            checkGameRestart.invoke(baseballGame);

            assertThat(isStartRequested.getBoolean(baseballGame)).isEqualTo(result);
        }

        @Test
        @DisplayName("플레이어가 종료를 선택했을 때 시작 요청이 아님을 테스트한다")
        void 종료_일_때_게임_종료() throws InvocationTargetException, IllegalAccessException {
            boolean result = false;
            String inputString = "2";

            InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
            System.setIn(inputStream);
            checkGameRestart.invoke(baseballGame);

            assertThat(isStartRequested.getBoolean(baseballGame)).isEqualTo(result);
        }
    }


}
