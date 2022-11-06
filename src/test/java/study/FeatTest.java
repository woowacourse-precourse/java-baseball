package study;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FeatTest {
    @Test
    void player_입력값_테스트() {
        Player p = new Player();
        p.setInputNum("345");
        List<Integer> result = new ArrayList<>();
        result.add(3);
        result.add(4);
        result.add(5);

        assertThat(p.getPlayerNum()).isEqualTo(result);
    }
}
