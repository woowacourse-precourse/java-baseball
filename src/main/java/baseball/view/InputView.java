package baseball.view;

import baseball.domain.Answer;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private final OutputView outputView = new OutputView();

    public Answer getInputNumber() {
        outputView.inputNumber();
        String input = Console.readLine();
        List<Integer> casting = parseToListInteger(input);
        return new Answer(casting);
    }

    private static List<Integer> parseToListInteger(String input) {
        return IntStream.range(0, input.length())
                .mapToObj(index -> Integer.parseInt(String.valueOf(input.charAt(index))))
                .collect(Collectors.toList());
    }

    public int getRestartFlag() {
        outputView.endGame();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
