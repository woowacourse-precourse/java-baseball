package baseball.game;

import baseball.domain.BaseballNumberBundle;
import baseball.domain.GameProgress;
import baseball.domain.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }

    /*
    @Test
    void inputBaseballNumbers() {
        BaseballNumberBundle b = player.inputBaseballNumbers();
        for(int n:b.getList()) {
            System.out.println(n);
        }
    }

    @Test
    void inputGameProgress() {
        GameProgress gp = player.inputGameProgress();
        System.out.println(gp.getProgress());
    }

     */

    @Test
    void removeSeparator() {
        String s;
        String e;

        s = "hello";
        s = player.removeSeparator(s);
        e = "hello";
        assertThat(s).isEqualTo(e);

        s = "h  e  l  l  o";
        s = player.removeSeparator(s);
        e = "hello";
        assertThat(s).isEqualTo(e);

        s = "  h\nello\n";
        s = player.removeSeparator(s);
        e = "hello";
        assertThat(s).isEqualTo(e);

        s = "/h 1 e 2 l. 3, l4.  o5,\n";
        s = player.removeSeparator(s);
        e = "h1e2l3l4o5";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void numberValid() {
        String s = "12345";
        player.numberValid(s);
    }
    @Test
    void numberValid2() {
        String s = "1a2345";
        try {
            player.numberValid(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
    @Test
    void numberValid3() {
        String s = "       b";
        try {
            player.numberValid(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
    @Test
    void numberValid4() {
        String s = "       1";
        try {
            player.numberValid(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    void baseballVaild() {
    }

    @Test
    void progressVaild() {
    }
}