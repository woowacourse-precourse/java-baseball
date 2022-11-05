package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        private static final String CORRECT_ANSWER_KOR = "스트라이크";
        private static final String SIMILAR_ANSWER_KOR = "볼 ";
        private static final String WRONG_ANSWER_KOR = "낫싱";
        private static final String USER_WANT_MORE = "1";
        private static final String USER_WANT_FINISH = "2";
        private static final int FORBIDDEN_NUMBER = 0;
        private static final int DEFAULT_VALUE_IF_KEY_DOES_NOT_EXIST = 0;

        public void play() {
            System.out.println("숫자 야구 게임을 시작합니다.");
            startGame();
        }

        private void startGame() {
            do {
                List<Integer> targetNumbers = getTargetNumbers();
                repeatUntilUserGetsPerfectAnswer(targetNumbers);
            } while (isUserWantMoreGame());
        }

        private List<Integer> getTargetNumbers() {
            List<Integer> targetNumbers = new ArrayList<>();

            while (targetNumbers.size() < PICK_COUNT) {
                int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

                if (!targetNumbers.contains(randomNumber)) {
                    targetNumbers.add(randomNumber);
                }
            }

            return targetNumbers;
        }

        private void repeatUntilUserGetsPerfectAnswer(List<Integer> targetNumbers) {
            Map<String, Integer> gameResult = new HashMap<>();

            do {
                gameResult.clear();
                List<Integer> userInputNumbers = getUserInputNumbers();
                summaryGameResult(userInputNumbers, targetNumbers, gameResult);
                printGameResult(gameResult);
            } while (gameResult.getOrDefault(CORRECT_ANSWER, DEFAULT_VALUE_IF_KEY_DOES_NOT_EXIST) != PICK_COUNT);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        private List<Integer> getUserInputNumbers() {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            return getUserInputNumbersIfAcceptable(input);
        }

        private List<Integer> getUserInputNumbersIfAcceptable(String input) {
            validateInputLength(input);
            List<Integer> numsList = getUserInputNumbersIfConvertible(input);
            validateUseForbiddenNumber(numsList);
            validateDuplicateValues(numsList);
            return numsList;
        }

        private void validateInputLength(String input) {
            if (input.length() != PICK_COUNT) {
                throw new IllegalArgumentException("입력값이 " + PICK_COUNT + "자리가 아닙니다.");
            }
        }

        private List<Integer> getUserInputNumbersIfConvertible(String input) {
            List<Integer> collect;

            try {
                collect = Arrays.stream(input.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력값을 숫자로 변환시킬 수 없습니다.");
            }

            return collect;
        }

        private void validateUseForbiddenNumber(List<Integer> numsList) {
            if (numsList.contains(FORBIDDEN_NUMBER)) {
                throw new IllegalArgumentException(
                        "숫자는 " + START_NUMBER + "부터 " + END_NUMBER + "까지만 사용되어야 합니다. " +
                        FORBIDDEN_NUMBER +"을 포함할 수 없습니다."
                );
            }
        }

        private void validateDuplicateValues(List<Integer> numsList) {
            Set<Integer> numsSet = new HashSet<>(numsList);

            if (numsList.size() != numsSet.size()) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }

        private void summaryGameResult(List<Integer> userInputNumbers,
                                       List<Integer> targetNumbers,
                                       Map<String, Integer> gameResult) {

            for (int idx = 0; idx < targetNumbers.size(); idx++) {
                int userNum = userInputNumbers.get(idx);
                int targetNum = targetNumbers.get(idx);

                if (userNum == targetNum) {
                    putGameResult(CORRECT_ANSWER, gameResult);
                    continue;
                }

                if (targetNumbers.contains(userNum)) {
                    putGameResult(SIMILAR_ANSWER, gameResult);
                }
            }
        }

        private void putGameResult(String accuracyResult, Map<String, Integer> gameResult) {
            Integer cnt = gameResult.getOrDefault(accuracyResult, DEFAULT_VALUE_IF_KEY_DOES_NOT_EXIST);
            gameResult.put(accuracyResult, cnt + 1);
        }

        private void printGameResult(Map<String, Integer> gameResult) {
            StringBuilder sb = new StringBuilder();

            appendGameResult(gameResult, sb, SIMILAR_ANSWER, SIMILAR_ANSWER_KOR);
            appendGameResult(gameResult, sb, CORRECT_ANSWER, CORRECT_ANSWER_KOR);
            String gameResultToString = createGameResultToString(sb);
            System.out.println(gameResultToString);
        }

        private void appendGameResult(Map<String, Integer> gameResult, StringBuilder sb,
                                      String answer, String answerKor) {

            if (gameResult.containsKey(answer)) {
                sb.append(gameResult.get(answer));
                sb.append(answerKor);
            }
        }

        private String createGameResultToString(StringBuilder sb) {
            if (sb.length() > 0) {
                return sb.toString();
            }

            return WRONG_ANSWER_KOR;
        }

        private boolean isUserWantMoreGame() {
            while (true) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = Console.readLine();

                if (USER_WANT_MORE.equals(input)) {
                    return true;
                }

                if (USER_WANT_FINISH.equals(input)) {
                    return false;
                }

                System.out.println("잘못된 값을 입력하셨습니다.");
            }
        }
    }
}
