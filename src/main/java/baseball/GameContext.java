package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** 게임 흐름을 제어하는 메서드를 제공합니다. */
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
        return (num <= '9'&& num >= '1');
    }
}
