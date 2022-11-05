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

    @Test
    void computer_각자리_숫자_다른지_테스트(){
        List<Integer> computerNumber = prepareGame.setComputerNumber();
        int state = 0;
        if(computerNumber.get(0) == computerNumber.get(1) || computerNumber.get(0) == computerNumber.get(2) || computerNumber.get(1) == computerNumber.get(2)){
            state = 1;
        }
        assertThat(state).isEqualTo(0);
    }
}
