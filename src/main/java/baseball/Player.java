package baseball;

import java.lang.reflect.Array;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;
public class Player {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private ArrayList<Integer> numbers;
    public Player() {}

    public void setNumbers() {
        inputMessage();
        String input = Console.readLine();
        numbers = new ArrayList<>();
        stringToList(input);
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void stringToList(String input) {
        String[] str = input.split("");

        for(String s : str){
            numbers.add(Integer.parseInt(s));
        }
    }

    public void inputMessage() {
        System.out.print(INPUT_MESSAGE);
    }
}
