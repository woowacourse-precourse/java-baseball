package baseball;

import baseball.service.Referee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    Referee referee;
    @BeforeEach
    void beforeEach(){
        referee = new Referee();
    }

    @Test
    void Referee_낫싱(){
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(4, 5, 6);

        int[] count = referee.getJudgementCount(computer,user);
        assertThat(new int[]{0,0}).isEqualTo(count);
        assertThat(referee.printStrikeAndBall(count)).isEqualTo("낫싱");
    }

    @Test
    void Referee_3스트라이크(){
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 2, 3);

        int[] count = referee.getJudgementCount(computer,user);
        assertThat(new int[]{3,0}).isEqualTo(count);
        assertThat(referee.printStrikeAndBall(count)).isEqualTo("3스트라이크");
    }

    @Test
    void Referee_1스트라이크_2볼(){
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 3, 2);

        int[] count = referee.getJudgementCount(computer,user);
        assertThat(new int[]{1,2}).isEqualTo(count);
        assertThat(referee.printStrikeAndBall(count)).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void Referee_3볼(){
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(3, 1, 2);

        int[] count = referee.getJudgementCount(computer,user);
        assertThat(new int[]{0,3}).isEqualTo(count);
        assertThat(referee.printStrikeAndBall(count)).isEqualTo("3볼");
    }
}
