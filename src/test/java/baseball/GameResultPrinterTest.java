package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GameResultPrinterTest {
    private GameResultPrinter printer;

    @BeforeEach
    void setUp() {
        printer = new GameResultPrinter();
    }
    @Order(1)
    @Test
    void NothingResultPrinter() {
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(0, 0, 1))), "낫싱");
    }

    @Order(2)
    @Test
    void StrikeResultPrinter() {
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(1, 0, 0))), "1 스트라이크");
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(2, 0, 0))), "2 스트라이크");
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(3, 0, 0))), "3 스트라이크");
    }
    @Order(3)
    @Test
    void BallResultPrinter() {
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(0, 1, 0))), "1 볼");
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(0, 2, 0))), "2 볼");
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(0, 3, 0))), "3 볼");
    }
    @Order(4)
    @Test
    void BallStrikeResultPrinter() {
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(1, 1, 0))), "1 볼 1 스트라이크");
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(2, 1, 0))), "2 볼 1 스트라이크");
    }
}