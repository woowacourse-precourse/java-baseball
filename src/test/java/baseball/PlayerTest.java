package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    void isValidInput_입력이_유효한_경우_참() {
        List<String> playerInput = List.of("012", "112", "12", "1234", "", "123");
        List<Boolean> expectedOutput = List.of(false, false, false, false, false, true);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.isValidInput(input))
                .collect(Collectors.toList());

        assertThat(realOutput).isEqualTo(expectedOutput);
    }

    @Test
    void convertStringToIntegerList_문자열_타입의_입력을_정수형_리스트로_변환() {
        String playerInput = "123";
        List<Integer> expectedOutput = List.of(1, 2, 3);

        List<Integer> realOutput = Player.convertStringToIntegerList(playerInput);

        assertThat(expectedOutput).isEqualTo(realOutput);
    }
}

