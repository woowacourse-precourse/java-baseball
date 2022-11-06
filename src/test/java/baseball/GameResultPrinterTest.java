package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultPrinterTest {
    private GameResultPrinter printer;

    @BeforeEach
    void setUp() {
        printer = new GameResultPrinter();
    }
    @Test
    void NothingResultPrinter() {
        assertEquals(printer.convertGameResult(new ArrayList<>(Arrays.asList(0, 0, 0))), "낫싱");
    }
}