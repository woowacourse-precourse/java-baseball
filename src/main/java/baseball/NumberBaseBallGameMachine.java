package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseBallGameMachine {
    Referee referee = new Referee();
    Message message = new Message();
    NumberMaker numberMaker = new NumberMaker();

    public void display(String message) {
        System.out.print(message);
    }

    public String getInputLine() {
        return Console.readLine();
    }

    public void makeNewAnswer() {
        referee.setAnswer(numberMaker.makeThreeDifferentNumberListInRange(1, 9));
    }

    public List<Integer> getThreeNumberInput() {
        String trimmedInput = getInputLine().strip();
        validateThreeNumbers(trimmedInput);
        return trimmedInput.chars().mapToObj(o -> Character.getNumericValue((char) o)).collect(Collectors.toList());
    }

    public void validateThreeNumbers(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("공백없이 연속된 3개의 숫자를 입력해야 합니다.");
        }
        Set<Character> charSet = input.chars().mapToObj(o -> (char) o).collect(Collectors.toSet());
        if (charSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야 합니다.");
        }
        charSet.forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException("숫자가 아닌 입력값이 존재합니다.");
            }
        });
    }

    public int getNewGameOrStop() {
        String trimInput = getInputLine().strip();
        validateNewGameInput(trimInput);
        return Integer.parseInt(trimInput);
    }

    public void validateNewGameInput(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("입력값이 한 개가 아닙니다.");
        }
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("입력값이 1이나 2가 아닙니다.");
        }
    }

    public boolean getInputResult() {
        display(message.requestThreeNumbers());
        List<Integer> judgeResult = referee.judgeList(getThreeNumberInput());
        display(message.result(judgeResult) + "\n");
        return isAnswer(judgeResult);
    }

    public boolean isAnswer(List<Integer> judge) {
        return judge.get(1) == 3;
    }

    public boolean askNewGameOrStop() {
        display(message.requestNewOrStop() + "\n");
        return getNewGameOrStop() == 1;
    }

    public void gameProgress() {
        boolean success = false;
        display(message.start() + "\n");
        while (!success) {
            success = getInputResult();
        }
        display(message.success() + "\n");
    }

    public void play() {
        boolean gameContinue = true;
        while (gameContinue) {
            makeNewAnswer();
            gameProgress();
            gameContinue = askNewGameOrStop();
        }
    }
}
