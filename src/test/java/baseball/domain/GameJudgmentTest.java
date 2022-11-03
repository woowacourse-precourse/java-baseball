package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameJudgmentTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void 컴퓨터_값이_비어있는지_확인() {
        List<Integer> randomNumbers = numberGenerator.createRandomNumbers();
        assertThat(randomNumbers).isNotEmpty();
    }

    @Test
    void 컴퓨터_숫자가_3개가_맞는지_확인() {
        List<Integer> randomNumbers = numberGenerator.createRandomNumbers();
        int size = randomNumbers.size();
        assertThat(size).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자가_중복이_있는지_확인() {
        List<Integer> randomNumbers = numberGenerator.createRandomNumbers();
        HashSet<Integer> hashSet = new HashSet<>(randomNumbers);

        boolean duplicateCheck = true;
        if (randomNumbers.size() != hashSet.size()) {
            duplicateCheck = false;
        }
        assertTrue(duplicateCheck);
    }
}