package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private boolean finish = false;

    private int strike = 0;
    private int ball = 0;

    private List<Integer> answer = new ArrayList<>();

    public void startGame() {
        answer = Computer.createAnswer();

        while (!finish) {
            initResult();
        }
    }

    private void initResult() {
        strike = 0;
        ball = 0;
    }
}
