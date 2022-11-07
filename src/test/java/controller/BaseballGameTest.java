package controller;

import model.Computer;
import model.PlayerRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {
    static PlayerRepository playerRepository = new PlayerRepository();
    static Computer computer = new Computer();

    @BeforeAll
    static void init() {
        while (computer.getLengthOfNumber() < 3) {
            computer.generateRandomNumber();
        }
    }

    @Test
    void 사용자와_컴퓨터_일치_확인() {
        playerRepository.setPlayerNumber(Integer.toString(computer.getComputerNumber()));

        System.out.println(computer.getComputerNumber());
        assertThat(BaseballGame.isCorrect(playerRepository, computer)).isEqualTo(true);
    }

    @Test
    void 볼_스트라이크_테스트() {
        playerRepository.setPlayerNumber(Integer.toString(computer.getComputerNumber()));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        BaseballGame.hintPrint(playerRepository, computer);

        assertThat(out.toString().trim()).isEqualTo("3스트라이크");
    }
}
