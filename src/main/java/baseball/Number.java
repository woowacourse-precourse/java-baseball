package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;


public class Number {

    private static final int SIZE_OF_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";

    private int[] digits;

    public int[] getDigits(){
        return this.digits;
    }

    public void setRandomNumber() {
        Set<Integer> randomNumberList = new HashSet<>();

        while(randomNumberList.size() < SIZE_OF_NUMBER) {
            randomNumberList.add(getRandomNumber());
        }

        this.digits = convertIntegerSetToIntArray(randomNumberList);
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private int[] convertIntegerSetToIntArray (Set<Integer> setTypeData) {
        return setTypeData.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void inputPrediction() {
        System.out.print(INPUT_SENTENCE);
        String prediction = Console.readLine();
        setDigits(prediction);
    }

    private void setDigits(String inputNumber) {

        if (!isCorrectInput(inputNumber)){
            throw new IllegalArgumentException();
        }

        this.digits = Arrays.stream(inputNumber.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private boolean isCorrectInput(String inputNumber) {
        return isCorrectLength(inputNumber) && isCorrectRange(inputNumber) && checkDuplicate(inputNumber);
    }

    private boolean isCorrectRange(String inputNumber) {
        Pattern numberPattern = Pattern.compile("^[1-9]*$");
        return numberPattern.matcher(inputNumber).matches();
    }

    private boolean isCorrectLength(String inputNumber) {
        return inputNumber.length() == SIZE_OF_NUMBER;
    }

    private boolean checkDuplicate(String inputNumber) {
        Set<Character> temp = new HashSet<>();
        for(char s: inputNumber.toCharArray()) {
            temp.add(s);
        }
        return inputNumber.length() == temp.size();
    }

}
