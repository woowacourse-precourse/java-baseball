package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private boolean finish = false;

    private int strike = 0;
    private int ball = 0;

    private List<Integer> answer = new ArrayList<>();

    public void startGame() {
        answer = Computer.createAnswer();
        Message.printStartMessage();

        while (!finish) {
            initResult();
        }
    }

    private void initResult() {
        strike = 0;
        ball = 0;
    }

    private void playGame() {
        Message.printInputMessage();
        List<Integer> input = getInput();

        getResult(input);
        Message.printHintMessage(strike, ball);

        if (strike == 3) {
            restartOrFinish();
        }
    }

    private List<Integer> getInput() {
        List<Integer> input = new ArrayList<>();
        String inputString = Console.readLine();

        for (char c : inputString.toCharArray()) {
            input.add(Character.getNumericValue(c));
        }

        if (!Validator.validateInput(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private void getResult(List<Integer> input) {
        for (int i = 0; i < 3; i++) {
            if (input.get(i).equals(answer.get(i))) {
                strike++;
            } else if (answer.contains(input.get(i))) {
                ball++;
            }
        }
    }

    private void restartOrFinish() {
        String inputString = Console.readLine();

        if (inputString.equals("1")) {
            answer = Computer.createAnswer();
        } else if (inputString.equals("2")) {
            finish = true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
