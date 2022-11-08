package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefenseNumberGeneratorTest {
    private static final int DEFENSE_NUMBERS_SIZE = 3;
    private static final int MAX_DEFENSE_NUMBER = 9;
    private static final int MIN_DEFENSE_NUMBER = 1;

    private static final DefenseNumberGenerator defenseNumberGenerator = DefenseNumberGenerator.getInstance();

    @Test
    void 유효한_방어_숫자가_생성되었는지_확인_길이가_세자리로_생성됐는지_확인() {
        List<Integer> defenseNumbers = defenseNumberGenerator.createDefenseNumbers();
        assertThat(defenseNumbers.size()).isEqualTo(DEFENSE_NUMBERS_SIZE);
    }

    @Test
    void 유효한_방어_숫자가_생성되었는지_확인_유효한_숫자로_생성됐는지_확인() {
        List<Integer> defenseNumbers = defenseNumberGenerator.createDefenseNumbers();
        System.out.println("defenseNumbers.toString() = " + defenseNumbers.toString());
        boolean isValidateNumber = defenseNumbers.stream()
                .allMatch(num -> num <= MAX_DEFENSE_NUMBER && num >= MIN_DEFENSE_NUMBER);
        assertThat(isValidateNumber).isTrue();
    }

    @Test
    void 유효한_방어_숫자가_생성되었는지_확인_서로_다른_세자리_숫자로_생성됐는지_확인() {
        List<Integer> defenseNumbers = defenseNumberGenerator.createDefenseNumbers();
        int count = (int)defenseNumbers.stream().distinct().count();
        assertThat(count)
                .isEqualTo(DEFENSE_NUMBERS_SIZE);
    }
}