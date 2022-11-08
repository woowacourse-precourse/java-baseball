package baseball.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumbersTest {

    @Test
    void countStrikes_같은_자리에_같은_수인_개수_반환() {
        //given
        List<Integer> numbers = Arrays.asList(2,9,8);
        ComputerNumbers computerNumbers = new ComputerNumbers(numbers);
        BaseballNumbers testBall1 = new BaseballNumbers("258");
        BaseballNumbers testBall2 = new BaseballNumbers("289");

        //when
        int strikeCount1 = computerNumbers.countStrikes(testBall1);
        int strikeCount2 = computerNumbers.countStrikes(testBall2);


        //then
        assertThat(strikeCount1).isEqualTo(2);
        assertThat(strikeCount2).isEqualTo(1);
    }

    @Test
    void countBalls_자리는_다르나_같은_수인_개수_반환() {
        //given
        List<Integer> numbers = Arrays.asList(7,9,2);
        ComputerNumbers computerNumbers = new ComputerNumbers(numbers);
        BaseballNumbers baseballNumbers = new BaseballNumbers("479");

        //when
        int ballCount = computerNumbers.countBalls(baseballNumbers);

        //then
        assertThat(ballCount).isEqualTo(2);
    }
}