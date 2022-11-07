package study;

import baseball.PlayGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayGameTest {
    Integer[] examComputerNumber = {1,3,5};
    Integer[] examUserNumber = {3,2,5};
    List<Integer> computerNumberTest = new ArrayList<>(Arrays.asList(examComputerNumber));
    List<Integer> userNumberTest = new ArrayList<>(Arrays.asList(examUserNumber));

    PlayGame playGameTest = new PlayGame(computerNumberTest, userNumberTest);

    @Test
    void 볼_스트라이크_세는_기능(){
        List<Integer> answer = List.of(1,1);

        assertThat(playGameTest.checkStrikeAndBallForTest()).isEqualTo(answer);
    }
}
