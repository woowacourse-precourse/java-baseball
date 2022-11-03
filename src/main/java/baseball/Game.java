package baseball;

import baseball.io.InputUtils;
import baseball.io.OutputUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Integer> inputNumbers;

    private void saveInputNumbersInGame(String input) {
        inputNumbers = input.chars().mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    public void play() {
        OutputUtils.printGameStartMessage();

        String input = InputUtils.readNumbersWrittenByUser();
        InputUtils.checkIsValidInput(input);
        saveInputNumbersInGame(input);
    }
}
