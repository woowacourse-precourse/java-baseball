package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임 흐름을 제어하는 메서드를 제공합니다.
 */
public class GameContext {
    private final static int ANSWER_LENGTH = 3;
    private final static int SELECTOR_LENGTH = 1;
    private String answer;
    private String userInput;
    private GameState state;

    public String getAnswer() {
        return answer;
    }

    public GameState getState() {
        return state;
    }

    public void initializeContext() {
        answer = getRandomNumber();
        state = GameState.RUNNING;
    }

    public String getRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < ANSWER_LENGTH)
            addDistinctRandomNumber(numbers);

        return numbers.stream().map(Object::toString)
                .collect(Collectors.joining());
    }

    public void addDistinctRandomNumber(List<Integer> numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        if (!numbers.contains(randomNumber))
            numbers.add(randomNumber);
    }

    public void handleUserInput() throws IllegalArgumentException {
        userInput = Console.readLine();

        if (!isValidityInput(userInput))
            throw new IllegalArgumentException();
        if (shouldDecideBallCount(userInput))
            decideBallCount(userInput);
    }

    private boolean isValidityInput(String userInput) {
        if (state == GameState.RUNNING && isNDigitNumberInRange(userInput, ANSWER_LENGTH))
            return true;
        else if (state == GameState.THREE_STRIKE && isNDigitNumberInRange(userInput, SELECTOR_LENGTH))
            return true;
        else
            return false;
    }

    private boolean isNDigitNumberInRange(String number, int n) {
        boolean retVal = true;

        if (number.length() != n)
            return false;

        for (char c : number.toCharArray())
            retVal = isNumberInRange(c) && retVal;

        return retVal;
    }

    private boolean isNumberInRange(char num) {
        return (num <= '9' && num >= '1');
    }

    private boolean shouldDecideBallCount(String userInput) {
        return (state == GameState.RUNNING) && isNDigitNumberInRange(userInput, ANSWER_LENGTH);
    }

    private void decideBallCount(String userInput) {
        Integer strike = 0;
        Integer ball = 0;

        for (int i = 0; i < userInput.length(); i++) {
            strike += addStrikeCount(userInput, i);
            ball += addBallCount(userInput, i);
        }
        printBallCount(ball, strike);

        if (strike == ANSWER_LENGTH)
            state = GameState.THREE_STRIKE;
    }

    private int addStrikeCount(String userInput, int index) {
        if (answer.indexOf(userInput.charAt(index)) == index)
            return 1;
        else
            return 0;
    }

    private int addBallCount(String userInput, int index) {
        int result = answer.indexOf(userInput.charAt(index));

        if (result >= 0 && result != index)
            return 1;
        else
            return 0;
    }

    private void printBallCount(int ball, int strike) {
        if (ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if (ball == 0 && strike != 0)
            System.out.println(String.format("%d스트라이크", strike));
        else if ( ball != 0 && strike == 0)
            System.out.println(String.format("%d볼", ball));
        else
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));

    }
}
