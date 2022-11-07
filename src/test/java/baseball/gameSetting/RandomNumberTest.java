package baseball.gameSetting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import baseball.utils.RandomNumber;

public class RandomNumberTest {

    @Test
    void check_exist_duplicated_number_in_list() {
        boolean testResult = true;
        boolean result = true;
        int count = 0;
        while (count < 1000) {
            List<Integer> randomNumberList = RandomNumber.generateUnduplicatedThreeNumbers();
            Set<Integer> numSet = new HashSet<>(randomNumberList);
            if (numSet.size() != randomNumberList.size()) {
                testResult = false;
            }
            count++;
        }
        assertThat(result).isEqualTo(testResult);
    }
}
