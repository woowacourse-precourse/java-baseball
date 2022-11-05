package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void createNumber_메서드로_반환된_리스트의_길이_검사(){
        List<Integer> numbers = randomNumberGenerator.createNumber();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void createNumber_메서드로_반환된_리스트_원소의_범위_검사(){
        List<Integer> numbers = randomNumberGenerator.createNumber();
        assertThat(numbers.stream().allMatch(v -> v>=1 && v<=9)).isTrue();
    }

    @Test
    void duplicateCheck_메서드_사용시_리스트에_값이_이미_존재한다면_true_반환() {
        List<Integer> numberList = List.of(1, 2, 3);

        boolean checkResult1 = randomNumberGenerator.duplicateCheck(numberList, 1);
        boolean checkResult2 = randomNumberGenerator.duplicateCheck(numberList, 2);
        boolean checkResult3 = randomNumberGenerator.duplicateCheck(numberList, 9);

        assertThat(checkResult1).isEqualTo(true);
        assertThat(checkResult2).isEqualTo(true);
        assertThat(checkResult3).isEqualTo(false);
    }
}