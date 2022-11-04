package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
public class Player {

    private List<Integer> numbers = new ArrayList<>();
    public Player() {}

    public void setNumbers() {
        String input = Console.readLine();
        stringToList(input);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void stringToList(String string) {
        char[] characterArray = string.toCharArray();

        for(char c : characterArray) {
            this.numbers.add((int)c - '0');
        }
    }
}
