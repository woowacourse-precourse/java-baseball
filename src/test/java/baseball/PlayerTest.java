package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void 타입_검사_테스트() {
        assertThatThrownBy(() -> {
            player.validateNumber("12삼");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 자리_수_검사_테스트() {
        assertThatThrownBy(() -> {
            player.validateNumber("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.LENGTH_EXCEPTION);
    }

    @Test
    void 중복_검사_테스트() {
        assertThatThrownBy(() -> {
            player.validateNumber("122");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DUPLICATION_EXCEPTION);
    }

    @Test
    void 범위_검사_테스트() {
        assertThatThrownBy(() -> {
            player.validateNumber("120");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.RANGE_EXCEPTION);
    }

    @Test
    void 힌트_문구_테스트() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));

        player.setHintCount(computerNumbers, "123");
        assertEquals(player.getHintMessage(), "1스트라이크");

        player.setHintCount(computerNumbers, "456");
        assertEquals(player.getHintMessage(), "1볼 1스트라이크");

        player.setHintCount(computerNumbers, "789");
        assertEquals(player.getHintMessage(), "낫싱");
    }
}
