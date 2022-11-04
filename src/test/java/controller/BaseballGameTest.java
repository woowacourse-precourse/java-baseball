package controller;

import model.Computer;
import model.PlayerRepository;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {
    PlayerRepository playerRepository = new PlayerRepository();
    Computer computer = new Computer();

    @Test
    void 사용자와_컴퓨터_일치_확인() {
        while (computer.getLengthOfNumber() < 3) {
            computer.generateRandomNumber();
        }
        playerRepository.setPlayerNumber(Integer.toString(computer.getComputerNumber()));

        System.out.println(computer.getComputerNumber());
        assertThat(BaseballGame.isCorrect(playerRepository, computer)).isEqualTo(true);
    }
}
