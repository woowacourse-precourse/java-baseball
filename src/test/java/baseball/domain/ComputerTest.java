package baseball.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void createRandomNumbers_해당_게임에_컴퓨터의_랜덤숫자_생성() {
        //given
        Computer computer = new Computer();

        //when
        List<Integer> randomNumbers = computer.createRandomNumbers();

        //then
        List<Integer> distinctNumbers = randomNumbers.stream().distinct().collect(Collectors.toList());
        assertThat(randomNumbers).isEqualTo(distinctNumbers);
    }

    @Test
    void createHint_플레이어_숫자와_컴퓨터_숫자_비교해_힌트_생성() {
        //given
        List<Integer> computerNumbers = Arrays.asList(1,4,8);
        Computer computer = new Computer(computerNumbers);
        String playerGuess1 = "248";
        String playerGuess2 = "184";

        List<Integer> answer1 = Arrays.asList(2,0);
        List<Integer> answer2 = Arrays.asList(1,2);

        //when
        Hint hint1 = computer.createHint(playerGuess1);
        Hint hint2 = computer.createHint(playerGuess2);

        //then
        assertThat(hint1.getStrikeBallCount()).isEqualTo(answer1);
        assertThat(hint2.getStrikeBallCount()).isEqualTo(answer2);
    }
}