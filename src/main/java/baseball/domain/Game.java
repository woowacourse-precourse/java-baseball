package baseball.domain;

import baseball.view.View;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int LENGTH = 3;
    private Computer computer;

    public Game() {
        computer = new Computer(LENGTH);
    }

    public void start() {
        int strike = 0;
        int ball = 0;
        computer.initComputerNumber();

        while(true) {
            List<Integer> userNumber = inputToIntegerList(View.inputView());
            ball = computer.countBall(userNumber);
            strike = computer.countStrike(userNumber);
            View.resultView(strike, ball);

            if(isComplete(strike)) {
                View.completeView(LENGTH);
                break;
            }
        }

        String restart = View.endView();
        if(restart.equals("1")) start();
    }

    private boolean isComplete(int strike) {
        if(LENGTH == strike) return true;
        else return false;
    }

    private List<Integer> inputToIntegerList(String input) {
        char[] chars = input.toCharArray();
        List<Integer> list = new ArrayList<>();

        for (char c : chars) {
            list.add(Character.getNumericValue(c));
        }

        return list;
    }
}
