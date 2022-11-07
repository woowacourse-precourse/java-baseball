package baseball.domain;

import baseball.message.PitchStatusMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PitchResultTest {

    private PitchResult pitchResult;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        pitchResult = new PitchResult();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(standardOut);
    }

    @Test
    void setResult() {
        String userInput = "712";
        List<Integer> numbers = List.of(7, 1, 3);

        pitchResult.setResult(userInput, numbers);

        assertThat(pitchResult.getStrikeCount()).isEqualTo(2);
    }

    @DisplayName("컴퓨터의 숫자와 위치는 다르지만, 같은 숫자의 갯수를 반환")
    @Test
    void setResult_getBallCount_success() {
        String userInput = "123";
        List<Integer> numbers = List.of(3, 4, 5);

        pitchResult.setResult(userInput, numbers);

        assertThat(pitchResult.getBallCount()).isEqualTo(1);
    }

    @DisplayName("컴퓨터의 숫자와 위치는 다르지만, 같은 숫자의 갯수를 반환 - 2")
    @Test
    void setResult_getBallCount_success_2() {
        String userInput = "123";
        List<Integer> numbers = List.of(2, 3, 4);

        pitchResult.setResult(userInput, numbers);

        assertThat(pitchResult.getBallCount()).isEqualTo(2);
    }

    @DisplayName("N개의 볼인 경우 \"N볼\" 출력후 줄 바꿈")
    @Test
    void getPitchStatusMessage() {
        String userInput = "123";
        List<Integer> numbers = List.of(2, 3, 4);
        pitchResult.setResult(userInput, numbers);

        assertThat(pitchResult.getPitchStatusMessage()).isEqualTo("2볼");
    }

    @DisplayName("N개의 스크라이크인 경우 \"N스트라이크\" 출력후 줄 바꿈")
    @Test
    void 스트라이크만_존재하는_메시지_출력() {
        String userInput = "123";
        List<Integer> numbers = List.of(1, 2, 4);
        pitchResult.setResult(userInput, numbers);

        assertThat(pitchResult.getPitchStatusMessage()).isEqualTo("2스트라이크");
    }

    @DisplayName("N개의 스크라이크인 경우 \"N스트라이크\" 출력후 줄 바꿈")
    @Test
    void 볼과_스트라이크_모두_존재하는_메시지_출력() {
        String userInput = "132";
        List<Integer> numbers = List.of(1, 2, 3);
        pitchResult.setResult(userInput, numbers);

        assertThat(pitchResult.getPitchStatusMessage()).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("스트라이크와 볼 미존재시 \"낫싱\" 출력후 줄 바꿈")
    @Test
    void 볼과_스트라이크_모두_존재하지않는_낫싱_메시지_출력() {
        String userInput = "123";
        List<Integer> numbers = List.of(4, 5, 6);
        pitchResult.setResult(userInput, numbers);

        assertThat(pitchResult.getPitchStatusMessage()).isEqualTo(PitchStatusMessage.NOTHING);
    }

}