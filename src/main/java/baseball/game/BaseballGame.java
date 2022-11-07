package baseball.game;

import static java.lang.Character.getNumericValue;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BaseballGame implements Game {

    private static final int GOAL_DIGIT = 3;
    private static final int START_POSSIBLE_NUMBER = 1;
    private static final int END_POSSIBLE_NUMBER = 9;

    private final List<Integer> computerNumbers = new ArrayList<>(GOAL_DIGIT);
    private final List<Integer> playerNumbers = new ArrayList<>(GOAL_DIGIT);

    private int strike;
    private int ball;

    @Override
    public void play() {
        printGameStartMessage();
        setComputerNumbers();
        do {
            String playerInput = input();
            setPlayerNumbers(playerInput);
            execute();
            printResult();
        } while (isNotCorrect());
    }

    private void setComputerNumbers() {
        List<Integer> uniqueNumbers = pickUniqueNumbersInRange(START_POSSIBLE_NUMBER, END_POSSIBLE_NUMBER, GOAL_DIGIT);
        this.computerNumbers.clear();
        this.computerNumbers.addAll(uniqueNumbers);
    }

    private List<Integer> pickUniqueNumbersInRange(int start, int end, int count) {
        LinkedHashSet<Integer> uniqueNumbers = new LinkedHashSet<>();
        while (uniqueNumbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            uniqueNumbers.add(randomNumber);
        }
        return new ArrayList<>(uniqueNumbers);
    }

    private void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private boolean isNotCorrect() {
        return this.strike != GOAL_DIGIT;
    }

    private String input() {
        printInputMessage();
        String playerInput = Console.readLine();
        if (isInvalid(playerInput)) {
            throw new IllegalArgumentException();
        }
        return playerInput;
    }

    private void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private boolean isInvalid(String playerInput) {
        return isInvalidLength(playerInput) ||
                isAnyCharacterNotNumeric(playerInput) ||
                isAnyDigitInvalidRange(playerInput) ||
                hasDuplicateNumber(playerInput);
    }

    private boolean isInvalidLength(String playerInput) {
        return playerInput.length() != GOAL_DIGIT;
    }

    private boolean isAnyCharacterNotNumeric(String playerInput) {
        return !playerInput.chars()
                .allMatch(Character::isDigit);
    }

    private boolean isAnyDigitInvalidRange(String playerInput) {
        return playerInput.chars()
                .anyMatch(digit -> isInvalidRange((char) digit));
    }

    private boolean isInvalidRange(char digit) {
        return START_POSSIBLE_NUMBER > getNumericValue(digit) ||
                getNumericValue(digit) > END_POSSIBLE_NUMBER;
    }

    private boolean hasDuplicateNumber(String playerInput) {
        long duplicateCount = playerInput.chars()
                .distinct()
                .count();
        return duplicateCount != GOAL_DIGIT;
    }

    private void setPlayerNumbers(String playerInput) {
        List<Integer> playerInputArray = playerInput.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
        this.playerNumbers.clear();
        this.playerNumbers.addAll(playerInputArray);
    }

    private void execute() {
        this.strike = getStrike();
        this.ball = getBall();
    }

    private int getStrike() {
        int strike = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (Objects.equals(playerNumbers.get(i), computerNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall() {
        int ball = 0;
        int order = 1;
        int[] numberIndexArray = new int[10];
        for (int i = 0; i < GOAL_DIGIT; i++) {
            numberIndexArray[computerNumbers.get(i)] = order++;
        }
        order = 1;
        for (int i = 0; i < GOAL_DIGIT; i++) {
            if (numberIndexArray[playerNumbers.get(i)] != 0 &&
                    numberIndexArray[playerNumbers.get(i)] != order) {
                ball++;
            }
            order++;
        }
        return ball;
    }

    private void printResult() {
        StringBuilder result = new StringBuilder();
        if (this.ball == 0 && this.strike == 0) {
            result.append("낫싱");
        }
        if (this.ball != 0) {
            result.append(this.ball).append("볼 ");
        }
        if (this.strike != 0) {
            result.append(this.strike).append("스트라이크 ");
        }
        result.append("\n");
        if (this.strike == GOAL_DIGIT) {
            result.append(GOAL_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        }
        System.out.print(result);
    }
}
