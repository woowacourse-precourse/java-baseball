package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    BaseballGame() {

    }

    public void start() {

    }

    void finishOneGame() {

    }

    boolean continueGame() {
        return false;
    }

    void finishEntireGame() {

    }


}

class Player {
    String input() {
        return Console.readLine();
    }

    public List<Integer> suggest() {
        String input = input();
        if (!validSuggestion()) throw new IllegalArgumentException();
        List<Integer> suggestion;
        suggestion = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
        return suggestion;
    }

    boolean validSuggestion() {
        return false;
    }

    boolean continueGame() {
        return false;
    }

    boolean validContinueGame() {
        return false;
    }

}

