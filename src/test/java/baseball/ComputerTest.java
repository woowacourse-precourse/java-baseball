package baseball;

import baseball.generator.MockRandomGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @CsvSource({"4,5,6,낫싱", "3,5,6,1볼", "2,3,1,3볼", "1,5,6,1스트라이크", "1,2,3,3스트라이크", "1,3,2,2볼 1스트라이크"})
    void 결과_메시지_출력_검증(int first, int second, int third, String resultMessage) {
        Computer computer = new Computer(new MockRandomGenerator(1, 2, 3));
        computer.getPlayerWinOrNotAndPrintResult(List.of(first, second, third));

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(resultMessage);
    }
}