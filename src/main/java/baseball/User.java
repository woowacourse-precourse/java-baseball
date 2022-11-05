package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    Numbers guess;

    void guess() {
        String input = Console.readLine();
        List<Integer> inputList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            inputList.add(c - '0');
        }
        guess = new Numbers(inputList);
        if (!guess.validation()) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }
}
