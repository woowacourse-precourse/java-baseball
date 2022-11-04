package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ComputerNumberGeneratorTest {
    public static final int NUMBER_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    @DisplayName("컴퓨터 숫자 중복 테스트")
    @Test
    void computerNumberDuplicate() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        List<Integer> computerNumbers = computerNumberGenerator.generateComputerNumber();
        Set<Integer> computerNumbersSet = new HashSet<>(computerNumbers);

        assertThat(computerNumbersSet.size()).isEqualTo(NUMBER_SIZE);
    }

    @DisplayName("생성된 컴퓨터 숫자가 3개인지 테스트")
    @Test
    void computerNumberSize() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        List<Integer> computerNumbers = computerNumberGenerator.generateComputerNumber();

        assertThat(computerNumbers.size()).isEqualTo(NUMBER_SIZE);
    }

    @DisplayName("컴퓨터 숫자들의 범위가 1~9인지 테스트")
    @Test
    void computerNumberRange() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        List<Integer> computerNumbers = computerNumberGenerator.generateComputerNumber();

        assertThat(computerNumbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER));
    }



}