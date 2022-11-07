package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RefereeTest {

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
    @ValueSource(strings = {"123", "789"})
    void 낫싱_테스트(String guess) {
        List<Integer> answer = List.of(4, 5, 6);
        Referee.judge(guess, answer);
        String output = "낫싱\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "689", "274"})
    void 원_볼_테스트(String guess) {
        List<Integer> answer = List.of(4, 1, 6);
        Referee.judge(guess, answer);
        String output = "1볼\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(strings = {"125", "247", "134"})
    void 투_볼_테스트(String guess) {
        List<Integer> answer = List.of(4, 1, 2);
        Referee.judge(guess, answer);
        String output = "2볼\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(output);
    }

    @Test
    void 쓰리_볼_테스트() {
        String guess = "123";
        List<Integer> answer = List.of(3, 1, 2);
        Referee.judge(guess, answer);
        String output = "3볼\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(strings = {"178", "458", "396"})
    void 원_스트라이크_테스트(String guess) {
        List<Integer> answer = List.of(1, 5, 6);
        Referee.judge(guess, answer);
        String output = "1스트라이크\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(strings = {"125", "176", "146"})
    void 투_스트라이크_테스트(String guess) {
        List<Integer> answer = List.of(1, 2, 6);
        Referee.judge(guess, answer);
        String output = "2스트라이크\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(output);
    }

    @Test
    void 쓰리_스트라이크_테스트() {
        String guess = "126";
        List<Integer> answer = List.of(1, 2, 6);
        Referee.judge(guess, answer);
        String output = "3스트라이크\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(output);
    }

    @Test
    void 스트라이크_볼_테스트() {
        String guess = "169";
        List<Integer> answer = List.of(1, 2, 6);
        Referee.judge(guess, answer);
        String output = "1볼 1스트라이크\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(output);
    }
}
