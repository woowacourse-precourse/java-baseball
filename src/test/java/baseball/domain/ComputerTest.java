package baseball.domain;

import baseball.constant.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ComputerTest {
    private Computer computer = new Computer();

    @Test
    void computer는_1부터_9까지의_정수를_만들어낸다() {
        for (int i = 0; i < 100; i++) {
            List<Integer> randomNumbers = computer.makeRandomNumbers();
            Assertions.assertThat(randomNumbers)
                    .anyMatch(num ->
                            num <= Constant.MAX_NUMBER && num >= Constant.MIN_NUMBER);
        }
    }

    @Test
    void computer는_중복된_숫자를_생성하지_않는다(){
        List<Integer> duplicateNumbers = new ArrayList<>(Arrays.asList(1, 1, 2));

        for (int i = 0; i < 100; i++) {
            List<Integer> randomNumbers = computer.makeRandomNumbers();
            Assertions.assertThat(randomNumbers.size())
                    .isEqualTo(randomNumbers.stream().distinct().count());
            Assertions.assertThat(randomNumbers.size())
                    .isNotEqualTo(duplicateNumbers.stream().distinct().count());
        }
    }

    @Test
    void 만약_3스트라이크면_isAnswer_메소드는_true를_반환한다(){
        List<Integer> playerInputs = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));

        computer.resultOfGame(playerInputs, randomNumbers);
        boolean result = computer.isAnswer();

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 만약_3스트라이크가_아니라면_isAnswer_메소드는_false를_반환한다(){
        List<Integer> playerInputs = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(1, 3, 2));

        computer.resultOfGame(playerInputs, randomNumbers);
        boolean result = computer.isAnswer();

        Assertions.assertThat(result).isFalse();
    }
}