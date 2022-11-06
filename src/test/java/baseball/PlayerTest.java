package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void 힌트_문구_테스트() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));

        player.setHintCount(computerNumbers, Arrays.asList(1, 2, 3));
        assertEquals(player.getHintMessage(), "1스트라이크");

        player.setHintCount(computerNumbers, Arrays.asList(4, 5, 6));
        assertEquals(player.getHintMessage(), "1볼 1스트라이크");

        player.setHintCount(computerNumbers, Arrays.asList(7, 8, 9));
        assertEquals(player.getHintMessage(), "낫싱");
    }

    @Test
    void 게임_종료_테스트() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        player.setHintCount(computerNumbers, Arrays.asList(1, 2, 3));

        assertTrue(player.isMaxStrike());
    }
}
