package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumericalComparisonTest {
    NumericalComparison numericalComparison = NumericalComparison.getInstance();

    @Test
    @DisplayName("두 리스트의 숫자를 비교하여 볼과 스트라이크 잘 표시하는지")
    void checkListValue() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(3, 2, 1);

        // when
        Map<String, Integer> compareList = numericalComparison.compareList(computerNumbers, userNumbers);

        // then
        assertEquals(Map.of("strike", 1, "ball", 2), compareList);
    }

    @Test
    @DisplayName("메서드를 실행할 때 마다 strike, ball count가 초기화 되는지")
    void isResetCounts() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(3, 2, 1);

        // when
        Map<String, Integer> compareList = numericalComparison.compareList(computerNumbers, userNumbers);
        Map<String, Integer> compareList2 = numericalComparison.compareList(computerNumbers, userNumbers);

        // then
        assertEquals(Map.of("strike", 1, "ball", 2), compareList);
        assertEquals(Map.of("strike", 1, "ball", 2), compareList2);
    }

    @Test
    @DisplayName("싱글톤패턴이 멀티 쓰레드 환경에서 하나의 객체를 유지하는지 테스트")
    void checkTreadSafeSingleton() {
        // given
        int threadsAmount = 500;

        // when
        Set<NumericalComparison> numericalComparisonsSet = Collections.newSetFromMap(new ConcurrentHashMap<>());
        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);
        for (int i = 0; i < threadsAmount; i++) {
            executorService.execute(() -> {
                NumericalComparison numericalComparison1 = NumericalComparison.getInstance();
                numericalComparisonsSet.add(numericalComparison1);
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES))
                executorService.shutdownNow();
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        // then
        assertEquals(1, numericalComparisonsSet.size());
    }
}