package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;


public class Number {

    private static final int SIZE_OF_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final boolean ERROR = false;

    private int[] digits;

    public Number() {}

    public int[] getDigits(){
        return this.digits;
    }

    private void setDigits(String input) {

        if (!isCorrectInput(input)){
            throw new IllegalArgumentException();
        }

        this.digits = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void setRandomNumber() {
        Set<Integer> randomNumberList = new HashSet<>();

        while(randomNumberList.size() < SIZE_OF_NUMBER) {
            randomNumberList.add(getRandomNumber());
        }

        this.digits = convertIntegerSetToIntArray(randomNumberList);
    }

    private int[] convertIntegerSetToIntArray (Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void inputPrediction() {
        System.out.println("숫자를 입력해주세요 : ");
        String prediction = Console.readLine();
        setDigits(prediction);
    }

    private boolean isCorrectInput(String input) {
        if(!isCorrectLength(input) || !isCorrectRange(input) || !checkDuplicate(input)) {
            return ERROR;
        }
        return true;
    }

    private boolean isCorrectRange(String input) {
        Pattern numberPattern = Pattern.compile("^[0-9]*$");
        return numberPattern.matcher(input).matches();
    }

    private boolean isCorrectLength(String input) {
        return input.length() == SIZE_OF_NUMBER;
    }

    private boolean checkDuplicate(String input) {
        Set<Character> temp = new HashSet<>();
        for(char s: input.toCharArray()) {
            temp.add(s);
        }
        return input.length() == temp.size();
    }

}
