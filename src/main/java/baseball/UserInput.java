package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static baseball.ConstValue.*;

public class UserInput {
    private final Set<String> valid_range = valid_range_number();
    private String input;
    private List<Integer> numbers;
    private String reStartOrQuitInput;

    private void putNumbers(List<Integer> numbers) {
        Score score = new Score();
        score.userNumbers(numbers);
    }

    private void putChoose(String input) {
        if (input.equals(RE_START_INPUT)) {
            Decision.reStart();
        }
        if (input.equals(QUIT_GAME_INPUT)) {
            Decision.quitGame();
        }
    }

    public void numbers() {
        Message.enterNumber();
        this.input = Console.readLine();
        isValid();
        convertNumbers();
        putNumbers(numbers);
    }

    public void reStartOrQuit() {
        Message.chooseRestartOrQuitGame();
        this.reStartOrQuitInput = Console.readLine();
        isValidRestartOrQuitGame();
        putChoose(this.reStartOrQuitInput);
    }

    private void convertNumbers() {
        this.numbers = Arrays.stream(Stream.of(input.split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .boxed()
                .collect(Collectors.toList());
    }

    public void isValid() {
        if (!isValidLength()) {
            throw new IllegalArgumentException("3자리의 수를 입력하셔야 합니다.");
        }
        if (!isValidRangeNumber()) {
            throw new IllegalArgumentException("1부터 9까지의 자연수를 입력하셔야 합니다.");
        }
        if (!isValidGuessNumber()) {
            throw new IllegalArgumentException("중복되지 않은 1부터 9까지의 자연수를 입력하셔야 합니다.");
        }

    }

    public void isValidRestartOrQuitGame() {
        if (!(isValidReStartMessage() || isValidQuitGameMessage())) {
            throw new IllegalArgumentException("새로운 게임을 원하시면 1, 게임 종료를 원하시면 2를 입력해주세요");
        }
    }

    private boolean isValidRangeNumber() {
        return !input.contains(OUT_OF_RANGE_NUMBER);
    }

    private boolean isValidLength() {
        return input.length() == NUMBERS_LENGTH;
    }

    private boolean isValidReStartMessage() {
        return this.reStartOrQuitInput.equals(RE_START_INPUT);
    }

    private boolean isValidQuitGameMessage() {
        return this.reStartOrQuitInput.equals(QUIT_GAME_INPUT);
    }

    private boolean isValidGuessNumber() {
        Set<String> inputSet = inputToSet();
        inputSet.retainAll(valid_range);
        return inputSet.size() == NUMBERS_LENGTH;
    }

    private Set<String> inputToSet() {
        return Pattern.compile("")
                .splitAsStream(input)
                .collect(Collectors.toSet());
    }

    private Set<String> valid_range_number() {
        return IntStream.rangeClosed(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }
}
