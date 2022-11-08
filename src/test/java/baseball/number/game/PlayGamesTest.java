package baseball.number.game;

import baseball.number.game.PlayGames;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayGamesTest extends NsTest{

    PlayGames playGames = new PlayGames();


    @Test
    @DisplayName("플레이어의_숫자가_컴퓨터의_숫자와_같을때까지_힌트를_출력하고_일치하면_끝낸다")
    void isMatchedTest() throws IOException {
        String input = "125\n132\n123";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        playGames.matchNumber(List.of(1,2,3));

        assertThat(out.toString()).contains("2스트라이크","2볼 1스트라이크", "3스트라이크");

    }

    @Test
    @DisplayName("게임종료 메시지 출력")
    void outputQuitGameMessageTest() {
        String quit = "1";
        playGames.outputQuitGameMessage(quit);
        assertThat("1").isEqualTo(quit);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        quit = "2";
        playGames.outputQuitGameMessage(quit);
        assertThat(out.toString()).contains("게임 종료");
        assertThat("2").isEqualTo(quit);

        quit = "hahyunwoo";
        playGames.outputQuitGameMessage(quit);

        assertThat(out.toString()).contains("1 또는 2를 입력해주세요");
        assertThat("1").isNotEqualTo(quit);
        assertThat("2").isNotEqualTo(quit);
    }

    @Test
    @DisplayName("PlayGames테스트가 잘 작동되는지 확인")
    void quitGameMessage() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        playGames.quitGameMessage();

        assertThat(out.toString()).contains("게임 종료");
    }

    @Test
    void playGamesTests() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("124", "132", "123","1", "586", "456", "2");
                    assertThat(output()).contains("2스트라이크", "2볼 1스트라이크","3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1,2,3,4,5,6
        );
    }

    @Override
    protected void runMain() {
        playGames.playGames();
    }
}
