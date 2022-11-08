package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultTest {
    
    @DisplayName("게임 종료 테스트")
    @Test

    void result_3Strike_Test() {
        Balls computerBalls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Balls playerBalls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));

        assertEquals(computerBalls.makeResult(playerBalls).toString(), "3스트라이크");
    }

    @DisplayName("낫싱 테스트")
    @Test

    void result_Nothing_Test() {
        Balls computerBalls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Balls playerBalls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));

        assertEquals(computerBalls.makeResult(playerBalls).toString(), "3스트라이크");
    }

    @DisplayName("스트라이크 테스트")
    @Test

    void result_Strike_Test() {
        Balls computerBalls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Balls playerBalls = new Balls(new ArrayList<>(Arrays.asList(4, 5, 6)));

        assertEquals(computerBalls.makeResult(playerBalls).toString(), "낫싱");
    }

    @DisplayName("볼 테스트")
    @Test

    void result_Ball_Test() {
        Balls computerBalls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Balls playerBalls = new Balls(new ArrayList<>(Arrays.asList(2, 3, 5)));

        assertEquals(computerBalls.makeResult(playerBalls).toString(), "2볼");
    }
    
}
