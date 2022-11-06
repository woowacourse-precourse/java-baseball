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

        while(!isComplete(strike)) {
            String input = View.inputView();

        }
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
