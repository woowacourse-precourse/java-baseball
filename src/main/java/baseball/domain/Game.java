package baseball.domain;

import baseball.view.View;

import java.util.ArrayList;
import java.util.List;
import static baseball.Setting.LENGTH;

public class Game {
    private Computer computer;

    public Game() {
        computer = new Computer();
    }

    public void start() {
        int strike = 0;
        int ball = 0;
        computer.initComputerNumber();

        while(!isComplete(strike)) {
            List<Integer> userNumber = inputToIntegerList(View.inputView());
            ball = computer.countBall(userNumber);
            strike = computer.countStrike(userNumber);
            View.resultView(strike, ball);
        }

        View.completeView(LENGTH);
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
