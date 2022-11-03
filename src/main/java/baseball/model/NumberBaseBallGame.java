package baseball.model;

import baseball.utils.GameNumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class NumberBaseBallGame {
    private Set<Integer> gameNumber;
    private boolean isProceeding;

    public NumberBaseBallGame() {
        this.gameNumber = GameNumberGenerator.generate();
        this.isProceeding = true;
    }

    public boolean isProceeding() {
        return this.isProceeding;
    }

    public void inputNumberValidate(String inputNumber){
        validateThreeLength(inputNumber);
        validateDuplicate(inputNumber);
    }

    private void validateThreeLength(String inputNumber) {
        String pattern = "[1-9]{3}";
        if (!inputNumber.matches(pattern)) {
            throw new IllegalArgumentException("서로다른 3자리 자연수를 입력해야 합니다.");
        }
    }

    private void validateDuplicate(String inputNumber) {
        Set<Character> inputNumbers = new HashSet<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            inputNumbers.add(inputNumber.charAt(i));
        }

        if (inputNumbers.size() < 3) {
            throw new IllegalArgumentException("서로다른 3자리 자연수를 입력해야 합니다.");
        }
    }
}
