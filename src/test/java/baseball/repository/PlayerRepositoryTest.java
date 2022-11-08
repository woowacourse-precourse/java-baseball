package baseball.repository;

import baseball.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("PlayerRepositoryTest")
class PlayerRepositoryTest {
    @DisplayName("setPlayer&getPlayer Test")
    @Test
    void setPlayerTest() {
        PlayerRepository playerRepository = new PlayerRepository();
        playerRepository.setPlayer(1,2,3);
        assertThat(playerRepository.getPlayer().getFirstNumber()).isEqualTo(1);
        assertThat(playerRepository.getPlayer().getSecondNumber()).isEqualTo(2);
        assertThat(playerRepository.getPlayer().getThirdNumber()).isEqualTo(3);
    }

}