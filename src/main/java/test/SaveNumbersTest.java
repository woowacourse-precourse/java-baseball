package test;

import model.GamePlayer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SaveNumbersTest {

    @Test
    void 입력값_저장() {
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.saveNumbers("123");

        assertThat(gamePlayer.numbers).isEqualTo(new int[]{1, 2, 3});
    }

}
