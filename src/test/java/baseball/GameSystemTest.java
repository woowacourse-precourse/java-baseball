package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class GameSystemTest {
    GameSystem gameSystem;

    @BeforeEach
    void initializeGameSystem(){
        gameSystem = new GameSystem();
    }

    @Test
    void 입력을_받으면_문자열로_반환(){
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = gameSystem.askOpinion();
        assertThat(result).isEqualTo(input);
    }

    @Test
    void 게임을_더_할_때_입력이_1이면_참(){
        assertThat(gameSystem.isMoreGame("1")).isTrue();
    }

    @Test
    void 게임을_더_할_때_입력이_2이면_거짓(){
        assertThat(gameSystem.isMoreGame("2")).isFalse();
    }

    @Test
    void 게임을_종료할_때_입력이_2이면_참(){
        assertThat(gameSystem.isEndOfGame("2")).isTrue();
    }

    @Test
    void 게임을_종료할_때_입력이_1이면_거짓(){
        assertThat(gameSystem.isEndOfGame("1")).isFalse();
    }

    @Test
    void 입력이_1도_2도_아닐_때_참(){
        assertThat(gameSystem.isNotRightAnswer("더하겠습니다")).isTrue();
    }
}
