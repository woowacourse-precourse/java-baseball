package study;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ForLoopTest {

    private static final String NANO_SECONDS_POSTFIX = " ns";

    @Test
    @DisplayName("For Loop 시간이 For-Each Loop 에 걸리는 시간보다 큰가")
    void is_time_taken_to_for_loop_is_bigger_than_forEach_loop() {
        List<Integer> list = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        long start = System.nanoTime();
        for (Integer integer : list) {
            int aa = integer + 1;
        }
        long end = System.nanoTime();
        long forEachTimeTaken = end - start;

        start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            int aa = list.get(i) + 1;
        }
        end = System.nanoTime();
        long forLoopTimeTaken = end - start;

        System.out.println("For-Each Loop 시간 = " + forEachTimeTaken + NANO_SECONDS_POSTFIX);
        System.out.println("For Loop 시간 = " + forLoopTimeTaken + NANO_SECONDS_POSTFIX);
        assertThat(forEachTimeTaken).isGreaterThanOrEqualTo(forLoopTimeTaken);
    }
}
