package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    void isInputSizeEqualToAnswerSize_입력의_자리수가_게임정답의_자리수와_동일한_경우_참() {

        List<String> playerInput = List.of("123", "12");
        List<Boolean> expectedOutput = List.of(true, false);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.isInputSizeEqualToAnswerSize(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void doesNotHaveDuplicateInputElement_입력에_중복된_문자가_없는_경우_참() {
        List<String> playerInput = List.of("123", "112");
        List<Boolean> expectedOutput = List.of(true, false);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.doesNotHaveDuplicateInputElement(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void hasOnlyNaturalNumberAsInput_입력이_자연수로만_구성된_경우_참() {
        List<String> playerInput = List.of("123", "012", "1a3");
        List<Boolean> expectedOutput = List.of(true, false, false);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.hasOnlyNaturalNumberAsInput(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

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

