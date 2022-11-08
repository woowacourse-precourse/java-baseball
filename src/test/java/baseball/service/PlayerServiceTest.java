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
    @Test
    @DisplayName("ballCount Test")
    void checkBallCount() {
        ArrayList<Integer> computerNumbers = new ArrayList<>(Arrays.asList(3,2,5));
        ArrayList<Integer> playerNumbers = new ArrayList<>(Arrays.asList(9,2,3));
        PlayerService playerService = new PlayerService();
        playerService.setPlayerNumber(playerNumbers);
        assertThat(playerService.checkBallCount(computerNumbers)).isEqualTo(Arrays.asList(1,1));
    }

}