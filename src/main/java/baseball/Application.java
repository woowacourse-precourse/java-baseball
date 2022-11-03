package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
            int[] intArrayValue = getIntArrayIfAcceptable(input);
            validateUse0(intArrayValue);
            validateDuplicateValues(intArrayValue);
            return intArrayValue;
        }
    }
}
