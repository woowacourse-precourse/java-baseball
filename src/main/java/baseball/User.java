package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public List<Integer> answer;


    public void inputUserAnswer() {
        answer = new ArrayList<>();

        String input = Console.readLine();
        if (input.length() != 3 || !input.matches("^[1-9]+$")) {
            throw new IllegalArgumentException();
        }

        String splitString[] = input.split("");

        answer.add(Integer.parseInt(splitString[0]));
        for (int i = 1; i < splitString.length; i++) {
            if (answer.contains(splitString[i])) {
                throw new IllegalArgumentException();
            }
            answer.add(Integer.parseInt(splitString[i]));
        }
    }
}
