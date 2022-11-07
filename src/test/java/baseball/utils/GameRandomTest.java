package baseball.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRandomTest {

    GameRandom random = GameRandom.getInstance();

    @Test
    @DisplayName("랜덤한 세 개의 숫자가 중복되지 않게 만들어지는지 테스트")
    void randomNumbersTest() {
        // given
        List<Integer> numbers = random.makeNumbers();

        // expected
        Assertions.assertEquals(3, new HashSet<>(numbers).size());
    }

    @Test
    @DisplayName("각 숫자가 1~9에 해당하는가")
    void randomNumbersValidationTest() {
        // given
        List<Integer> numbers = random.makeNumbers();

        // expected
        Assertions.assertTrue(String.valueOf(numbers.get(0)).matches("[1-9]"));
        Assertions.assertTrue(String.valueOf(numbers.get(1)).matches("[1-9]"));
        Assertions.assertTrue(String.valueOf(numbers.get(2)).matches("[1-9]"));
    }

    @Test
    @DisplayName("싱글톤패턴이 멀티 쓰레드 환경에서 하나의 객체를 유지하는지 테스트")
    void checkTreadSafeSingleton() {
        // given
        int threadsAmount = 500;

        // when
        Set<GameRandom> makeRandom1Set = Collections.newSetFromMap(new ConcurrentHashMap<>());
        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);
        for (int i = 0; i < threadsAmount; i++) {
            executorService.execute(() -> {
                GameRandom makeRandom1 = GameRandom.getInstance();
                makeRandom1Set.add(makeRandom1);
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
        assertEquals(1, makeRandom1Set.size());
    }
}