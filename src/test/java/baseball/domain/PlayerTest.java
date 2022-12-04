package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    public void 플레이어_테스트(){
        String number = "123";
        Player player = new Player();
        player.setPlayerNumber(number);
        assertThat(player.getPlayerNumber()).isEqualTo("123");
    }
}
