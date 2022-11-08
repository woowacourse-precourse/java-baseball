package baseball.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {
    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }

    @Test
    void removeSeparator() {
        String s;
        String e;

        s = "hello";
        s = player.removeSeparator(s);
        e = "hello";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void removeSeparator2() {
        String s;
        String e;

        s = "h  e  l  l  o";
        s = player.removeSeparator(s);
        e = "hello";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void removeSeparator3() {
        String s;
        String e;

        s = "  h\nello\n";
        s = player.removeSeparator(s);
        e = "hello";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void removeSeparator4() {
        String s;
        String e;

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
        boolean flag = false;
        String s = "1a2345";
        try {
            player.numberValid(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    void numberValid3() {
        boolean flag = false;
        String s = "       b";
        try {
            player.numberValid(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    void numberValid4() {
        boolean flag = false;
        String s = "       1";
        try {
            player.numberValid(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    void baseballVaild() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        player.baseballValid(list);

        boolean flag = false;
        list.add(4);
        try {
            player.baseballValid(list);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    void progressVaild1() {
        player.progressValid(1);
    }
    @Test
    void progressVaild2() {
        player.progressValid(2);
    }
    @Test
    void progressVaild3() {
        boolean flag = false;
        try {
            player.progressValid(3);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
    }
}