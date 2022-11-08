package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void makeAnnouncementNothing() {
        Game game = new Game();
        List<String> hint = new ArrayList<>();
        hint.add("0");
        hint.add("0");

        String nothing = game.makeAnnouncement(hint);
        assertEquals("낫싱", nothing);
    }

    @Test
    void makeAnnouncementOneBall() {
        Game game = new Game();
        List<String> hint = new ArrayList<>();
        hint.add("1");
        hint.add("0");

        String oneBall = game.makeAnnouncement(hint);
        assertEquals("1볼", oneBall);
    }

    @Test
    void makeAnnouncementOneStrike() {
        Game game = new Game();
        List<String> hint = new ArrayList<>();
        hint.add("0");
        hint.add("1");

        String oneStrike = game.makeAnnouncement(hint);
        assertEquals("1스트라이크", oneStrike);
    }

    @Test
    void makeAnnouncementOneBallOneStrike() {
        Game game = new Game();
        List<String> hint = new ArrayList<>();
        hint.add("1");
        hint.add("1");

        String oneBallOneStrike = game.makeAnnouncement(hint);
        assertEquals("1볼 1스트라이크", oneBallOneStrike);
    }
}