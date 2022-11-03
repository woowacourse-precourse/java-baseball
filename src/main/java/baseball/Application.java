package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        NumbersBaseballGame numbersBaseballGame = new NumbersBaseballGame();
        numbersBaseballGame.play();
    }

    static class NumbersBaseballGame {
        private static final int START_NUMBER = 1;
        private static final int END_NUMBER = 9;
        private static final int PICK_COUNT = 3;
        private static final String CORRECT_ANSWER = "strike";
        private static final String SIMILAR_ANSWER = "ball";

        public void play() {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> targetNumbers = getTargetNumbers();
            repeatUntilUserHitsTargetNumber();
        }

        private List<Integer> getTargetNumbers() {
            return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT);
        }

        private void repeatUntilUserHitsTargetNumber() {
            Map<String, Integer> gameResult = new HashMap<>();

            do {
                int[] userInput = getUserInput();
                getGameResult(userInput, gameResult);
                printGameResult(gameResult);
            } while (gameResult.get(CORRECT_ANSWER) != PICK_COUNT);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        private int[] getUserInput() {
            String input = Console.readLine();
            return getValueIfAcceptable(input);
        }

        private int[] getValueIfAcceptable(String input) {
            validateInputLength(input);
            List<Integer> numsList = getNumsListIfAcceptable(input);
            validateUse0(numsList);
            validateDuplicateValues(numsList);
            return numsList;
        }

        private void validateInputLength(String input) {
            if (input.length() != PICK_COUNT) {
                throw new IllegalArgumentException("입력값이 " + PICK_COUNT + "자리가 아닙니다.");
            }
        }

        private List<Integer> getNumsListIfAcceptable(String input) {
            String[] inputArray = input.split("");
            List<Integer> numsList = new ArrayList<>();

            try {
                for (String s : inputArray) {
                    numsList.add(Integer.parseInt(s));
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력값을 숫자로 변환시킬 수 없습니다.");
            }

            return numsList;
        }

        private void validateUse0(List<Integer> numsList) {
            if (numsList.contains(0)) {
                throw new IllegalArgumentException("숫자는 1부터 9까지만 사용되어야 합니다. 0을 포함할 수 없습니다.");
            }
        }
    }
}
