package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {
    private static final int BASEBALL_COUNT = 3;
    private static final int MIN_RANGE_VALUE = 1;
    private static final int MAX_RANGE_VALUE = 9;

    private Baseballs answer;

    public Computer() {
    }

    public void generateAnswer() {
        this.answer = Baseballs.of(generateRandomAnswerInput());
    }

    public Result resultBy(Player player) {
        return this.answer.calculateResult(player.submitAnswer());
    }

    private String generateRandomAnswerInput() {
        String generatedRandomAnswerInput = "";

        while (generatedRandomAnswerInput.length() < BASEBALL_COUNT) {
            generatedRandomAnswerInput = tryToAppendNewValue(generatedRandomAnswerInput);
        }

        return generatedRandomAnswerInput;
    }

    private String tryToAppendNewValue(String generatedRandomAnswerInput) {
        int selectedValue = Randoms.pickNumberInRange(MIN_RANGE_VALUE,MAX_RANGE_VALUE);
        if (!generatedRandomAnswerInput.contains(String.valueOf(selectedValue))) {
            generatedRandomAnswerInput += selectedValue;
        }
        return generatedRandomAnswerInput;
    }
}
