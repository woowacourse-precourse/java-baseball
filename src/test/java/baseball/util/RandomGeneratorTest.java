package baseball.util;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;


public class RandomGeneratorTest {

    @Test
    void genNumberList_메서드는_N_입력만큼_N개_반환() {
        int input = 3;
        List<Integer> result = RandomGenerator.genNumberList(input);
        assertThat(result.size()).isEqualTo(input);
    }

    @Test
    void genNumberList_메서드는_종복없는_리스트를_반환() {
        int input = 5;
        List<Integer> result = RandomGenerator.genNumberList(input);
        Set<Integer> set = new HashSet<>(result);
        assertThat(result.size()).isEqualTo(set.size());
    }
}
