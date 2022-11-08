package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    @Test
    void calculateCount() {

        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> digitList = List.of(1, 3, 2);
        List<Integer> result = List.of(2, 1);

        assertThat(Count.calculateCount(answer, digitList)).isEqualTo(result);

    }
}