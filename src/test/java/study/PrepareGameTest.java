package study;

import baseball.PrepareGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrepareGameTest {

    PrepareGame prepareGame = new PrepareGame();

    @Test
    void computer_숫자_세팅_테스트(){
        List<Integer> computerNumber = prepareGame.setComputerNumber();
        assertThat(computerNumber.size()).isEqualTo(3);
    }
}
