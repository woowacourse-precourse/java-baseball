package baseball.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameConsoleTest extends NsTest {
    GameConsole console = GameConsole.getInstance();
    @Test
    @DisplayName("사용자 입력테스트")
    void userInputTest() {
        // given
        String number = "123";
        run(number);

        // when
        String inputNum = console.input();

        // then
        assertEquals("123",inputNum);
    }

    @Test
    @DisplayName("console창 테스트")
    void consoleOutput() {
        // given
        String message = "message";

        // when
        console.print(message);

        // then
        assertThat(output()).isEqualTo("message");
    }

    @Test
    @DisplayName("console창 테스트2")
    void consoleOutput2() {
        // given
        String message = "message";

        // when
        console.println(message);

        // then
        assertThat(output()).isEqualTo("message");
    }

    @Test
    @DisplayName("싱글톤패턴이 멀티 쓰레드 환경에서 하나의 객체를 유지하는지 테스트")
    void checkTreadSafeSingleton() {
        // given
        int threadsAmount = 500;

        // when
        Set<GameConsole> gameConsoleSet = Collections.newSetFromMap(new ConcurrentHashMap<>());
        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);
        for (int i = 0; i < threadsAmount; i++) {
            executorService.execute(() -> {
                GameConsole gameConsole = GameConsole.getInstance();
                gameConsoleSet.add(gameConsole);
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
        assertEquals(1, gameConsoleSet.size());
    }

    @Override
    protected void runMain() {

    }
}