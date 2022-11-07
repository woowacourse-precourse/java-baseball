package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("PlayerService Test")
class PlayerServiceTest {

    @DisplayName("Player의 숫자 저장 및 불러오기")
    @Test
    void playerServiceTest() {
        PlayerService playerService = new PlayerService();
        ArrayList<Integer> playerInputNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        playerService.setPlayerNumber(playerInputNumbers);
        assertThat(playerService.getPlayerNumber()).isEqualTo(playerInputNumbers);
    }

}