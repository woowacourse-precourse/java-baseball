package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
public class Player {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private List<Integer> numbers = new ArrayList<>();
    public Player() {}

    public void setNumbers() {
        inputMessage();
        String input = Console.readLine();
        stringToList(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void stringToList(String string) {
        char[] characterArray = string.toCharArray();

        for(char c : characterArray) {
            numbers.add((int)c - '0');
        }
    }

    public void inputMessage() {
        System.out.print(INPUT_MESSAGE);
    }
}
