package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> answer = new ArrayList<>();

    public Game(List<Integer> randomNumberList) {
        this.answer = randomNumberList;
    }
}
