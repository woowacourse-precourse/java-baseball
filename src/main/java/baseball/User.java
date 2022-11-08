package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Numbers guess;

    void guess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> inputList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            inputList.add(c - '0');
        }
        guess = Numbers.of(inputList);
    }

    public int get(int i) {
        return guess.get(i);
    }
}
