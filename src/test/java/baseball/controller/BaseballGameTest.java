package baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    @DisplayName("strikeCount 기능 구현")
    void testReturnCorrectStrikeCount() {
        List<Integer> userNum = List.of(1, 2, 3);
        List<Integer> computerNum = List.of(4, 2, 8);

        BaseballGame baseballGame = new BaseballGame(userNum, computerNum);
        assertEquals(1, baseballGame.STRIKE_COUNT, "must be 1");
    }

    @Test
    @DisplayName("ballCount 기능 구현")
    void testReturnCorrectBallCount() {
        List<Integer> userNum = List.of(1, 2, 3);
        List<Integer> computerNum = List.of(3, 8, 1);

        BaseballGame baseballGame = new BaseballGame(userNum, computerNum);
        assertEquals(2, baseballGame.BALL_COUNT, "must be 2");
    }

    @Test
    @DisplayName("모든 숫자를 정확히 맞췄을때")
    void testMachedAllNumberMethod() {
        List<Integer> userNum = List.of(1, 2, 3);
        List<Integer> computerNum = List.of(3, 8, 1);

        BaseballGame baseballGame = new BaseballGame(userNum, computerNum);
        assertFalse(baseballGame.matchedAllNumber(), "must return false");

        userNum = List.of(1, 2, 3);
        computerNum = List.of(1, 2, 3);

        baseballGame = new BaseballGame(userNum, computerNum);
        assertTrue(baseballGame.matchedAllNumber(), "must return true");
    }
}