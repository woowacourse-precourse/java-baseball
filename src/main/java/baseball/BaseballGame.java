package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballGame {

    private List<Integer> answerNums;
    private List<Integer> inputNums;

    public void gameStart() {
        BaseballGameResult gameResult = new BaseballGameResult();

        printGameStartMessage();
        this.answerNums = generateRandomAnswerNums();
        int gameEndSignal = 0;
        while (gameEndSignal != 2) {

            this.inputNums = getGameInput();

            gameResult = new BaseballGameResult(answerNums, inputNums);

            printGameResultMessage(gameResult);

            if (gameResult.numOfStrikes() == 3) {
                printGameEndMessage();
                gameEndSignal = getGameRestartInput();
            }

            if (gameEndSignal == 1) {
                printGameStartMessage();
                this.answerNums = generateRandomAnswerNums();
                gameEndSignal = 0;
            }
        }
    }

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResultMessage(BaseballGameResult gameResult) {
        System.out.println(gameResult);
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public List<Integer> generateRandomAnswerNums() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNum)) {
                randomNums.add(randomNum);
            }
        }
        return randomNums;
    }

    public List<Integer> getGameInput() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        if (isIllegalGameInput(Integer.parseInt(input))) {
            throw new IllegalArgumentException();
        }

        return stringToIntList(input);
    }

    public int getGameRestartInput() throws IllegalArgumentException {
        int input = Integer.parseInt(Console.readLine());

        if (input != 1 && input != 2) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public List<Integer> stringToIntList(String numString) {
        List<Integer> intList = new ArrayList<>();

        for (char num : numString.toCharArray()) {
            intList.add(Character.getNumericValue(num));
        }

        return intList;
    }

    public Boolean isIllegalGameInput(int gameInput) {
        if (gameInput <= 111 || 999 <= gameInput) {
            return Boolean.TRUE;
        }

        if (checkDuplicateNums(gameInput)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public Boolean checkDuplicateNums(int gameInput) {
        List<Integer> checkList = stringToIntList(String.valueOf(gameInput));

        List<Integer> removeDuplicateList = new ArrayList<>(new HashSet<>(checkList));

        if (checkList.size() == removeDuplicateList.size()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public BaseballGameResult getResultOfGame() {
        return new BaseballGameResult(this.answerNums, this.inputNums);
    }
}
