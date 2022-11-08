package baseball.game;

import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResetCountTest {
    static Player player = new Player();
    static Player opponent = new Player();
    static int strike=2;
    static int ball=1;
    public void initialize(){
        strike=0;
        ball=0;
    }
    @Test
    public void count_Ball_Strike_Count_Test(){
        int strike=0;
        int ball=0;
        List<Integer> answer=List.of(strike,ball);

        initialize();
        List<Integer> expectedAnswer=new ArrayList<>();
        expectedAnswer.add(ResetCountTest.strike);
        expectedAnswer.add(ResetCountTest.ball);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
}
