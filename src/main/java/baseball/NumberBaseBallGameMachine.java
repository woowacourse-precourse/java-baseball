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
        if (input.length() < 3) {
            throw new IllegalArgumentException("입력값이 부족합니다. (3개 필요)");
        }
        if (input.length() > 3) {
            throw new IllegalArgumentException("입력값이 너무 많습니다. (3개 필요, 중간 공백도 입력으로 판단)");
        }

        Set<Character> charSet = input.chars().mapToObj(o -> (char) o).collect(Collectors.toSet());
        charSet.forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException("숫자가 아닌 입력값이 존재합니다.");
            }
            if (o == '0') {
                throw new IllegalArgumentException("1에서 9사이의 입력값만 유효합니다.");
            }
        });
        if (charSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야 합니다.");
        }
    }

    public int getNewGameOrStop() {
        String trimInput = getInputLine().strip();
        validateNewGameInput(trimInput);
        return Integer.parseInt(trimInput);
    }

    public void validateNewGameInput(String input) {
        if (input.length() < 1) {
            throw new IllegalArgumentException("입력값이 부족합니다. (1개 필요)");
        }
        if (input.length() > 1) {
            throw new IllegalArgumentException("입력값이 너무 많습니다. (1개 필요)");
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
        while (!success) {
            success = getInputResult();
        }
        display(message.success() + "\n");
    }

    public void play() {
        boolean gameContinue = true;
        display(message.start() + "\n");
        while (gameContinue) {
            makeNewAnswer();
            gameProgress();
            gameContinue = askNewGameOrStop();
        }
    }
}
