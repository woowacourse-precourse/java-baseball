package baseball.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class GameResultTest {

    @Test
    void 스트라이크_3개_일때_3스트라이크_출력(){
        // given
        int strikeCount = 3;
        int ballCount = 0;
        String expectedMessage = "3스트라이크\n";

        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResult gameResult = new GameResult(strikeCount, ballCount);
        gameResult.show();

        // then
        assertThat(expectedMessage).isEqualTo(out.toString());
    }

    @Test
    void 스트라이크_2개_볼_1개_일때_1볼_2스트라이크_출력(){
        // given
        int strikeCount = 2;
        int ballCount = 1;
        String expectedMessage = "1볼 2스트라이크\n";

        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResult gameResult = new GameResult(strikeCount, ballCount);
        gameResult.show();

        // then
        assertThat(expectedMessage).isEqualTo(out.toString());
    }

    @Test
    void 스트라이크_1개_볼_2개_일때_2볼_1스트라이크_출력(){
        // given
        int strikeCount = 1;
        int ballCount = 2;
        String expectedMessage = "2볼 1스트라이크\n";

        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResult gameResult = new GameResult(strikeCount, ballCount);
        gameResult.show();

        // then
        assertThat(expectedMessage).isEqualTo(out.toString());
    }

    @Test
    void 스트라이크_1개_일때_1스트라이크_출력(){
        // given
        int strikeCount = 1;
        int ballCount = 0;
        String expectedMessage = "1스트라이크\n";

        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResult gameResult = new GameResult(strikeCount, ballCount);
        gameResult.show();

        // then
        assertThat(expectedMessage).isEqualTo(out.toString());
    }

    @Test
    void 볼_1개_일때_1볼_출력(){
        // given
        int strikeCount = 0;
        int ballCount = 1;
        String expectedMessage = "1볼\n";

        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResult gameResult = new GameResult(strikeCount, ballCount);
        gameResult.show();

        // then
        assertThat(expectedMessage).isEqualTo(out.toString());
    }

    @Test
    void 스트라이크_0개_볼_0개_일때_낫싱_출력(){
        // given
        int strikeCount = 0;
        int ballCount = 0;
        String expectedMessage = "낫싱\n";

        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResult gameResult = new GameResult(strikeCount, ballCount);
        gameResult.show();

        // then
        assertThat(expectedMessage).isEqualTo(out.toString());
    }
}