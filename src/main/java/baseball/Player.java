package baseball;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
public class Player {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_SIZE = 3;

    private ArrayList<Integer> numbers;
    public Player() {}

    public void setNumbers() {
        inputMessage();
        String input = Console.readLine();
        if(!isValidateInput(input)){
            throw new IllegalArgumentException();
        }
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

    public boolean isValidateInput(String input) {
        if(!isValidateLength(input) || isZero(input) || isRepeat(input)){
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidateLength(String input) {
        if(input.length() != NUMBER_SIZE) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isRepeat(String input) {
        int[] units = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
        if(units[0] == units[1] || units[0] == units[2] || units[1] == units[2]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isZero(String input) {
        if(input.contains("0")) {
            return true;
        } else {
            return false;
        }
    }
}
