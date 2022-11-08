package study;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ForLoopTest {

    private static final int TEN_POWER_SIX = 1000_000;

    @Test
    @DisplayName("For Loop 시간이 For-Each Loop 에 걸리는 시간보다 큰가")
    void is_time_taken_to_for_loop_is_bigger_than_forEach_loop() {
        List<Integer> list = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        long forEachTimeTaken = measureTimeOf(() -> {
            for (Integer integer : list) {
                int aa = integer + 1;
            }
        });

        long forLoopTimeTaken = measureTimeOf(() -> {
            for (int i = 0; i < list.size(); i++) {
                int aa = list.get(i) + 1;
            }
        });

        printDifference(forEachTimeTaken, forLoopTimeTaken);

        assertThat(forEachTimeTaken).isGreaterThanOrEqualTo(forLoopTimeTaken);
    }

    private void printDifference(long forEachTimeTaken, long forLoopTimeTaken) {
        System.out.printf("For Loop 시간 = %d ns = %f ms\n", forLoopTimeTaken, (double)forLoopTimeTaken / TEN_POWER_SIX);
        System.out.printf("For-Each Loop 시간 = %d ns = %f ms\n", forEachTimeTaken,
                (double)forEachTimeTaken / TEN_POWER_SIX);
        System.out.printf("차이 = %f ms\n", (double)Math.abs(forEachTimeTaken - forLoopTimeTaken) / TEN_POWER_SIX);
    }

    private long measureTimeOf(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long end = System.nanoTime();
        return end - start;
    }
}
