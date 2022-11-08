package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GameResultConverterTest {
    private GameResultConverter converter;

    @BeforeEach
    void setUp() {
        converter = new GameResultConverter();
    }
    @Order(1)
    @DisplayName("Nothing 확인")
    @Test
    void NothingResultPrinter() {
        assertEquals("낫싱", converter.convertGameResult(new ArrayList<>(Arrays.asList(0, 0, 1))));
    }

    @Order(2)
    @DisplayName("Ball 확인")
    @Test
    void BallResultPrinter() {
        assertEquals("1볼", converter.convertGameResult(new ArrayList<>(Arrays.asList(0, 1, 0))));
        assertEquals("2볼", converter.convertGameResult(new ArrayList<>(Arrays.asList(0, 2, 0))));
        assertEquals("3볼", converter.convertGameResult(new ArrayList<>(Arrays.asList(0, 3, 0))));
    }

    @Order(3)
    @DisplayName("Strike 확인")
    @Test
    void StrikeResultPrinter() {
        assertEquals("1스트라이크", converter.convertGameResult(new ArrayList<>(Arrays.asList(1, 0, 0))));
        assertEquals("2스트라이크", converter.convertGameResult(new ArrayList<>(Arrays.asList(2, 0, 0))));
        assertEquals("3스트라이크", converter.convertGameResult(new ArrayList<>(Arrays.asList(3, 0, 0))));
    }

    @Order(4)
    @DisplayName("Ball + Strike 확인")
    @Test
    void BallStrikeResultPrinter() {
        assertEquals("1볼 1스트라이크", converter.convertGameResult(new ArrayList<>(Arrays.asList(1, 1, 0))));
        assertEquals("2볼 1스트라이크", converter.convertGameResult(new ArrayList<>(Arrays.asList(1, 2, 0))));
    }
}