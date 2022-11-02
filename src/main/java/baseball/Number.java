package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Number {

    private static final int SIZE_OF_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int[] digits;

    public Number() {}

    public int[] getDigits(){
        return this.digits;
    }

    private void setDigits(String input) {
        this.digits = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void setRandomNumber() {
        ArrayList<Integer> randomNumberList = new ArrayList<>();

        while(randomNumberList.size() != SIZE_OF_NUMBER) {
            randomNumberList.add(getRandomNumber());
        }

        this.digits = convertIntegerSetToIntArray(randomNumberList);
    }

    private int[] convertIntegerSetToIntArray (ArrayList<Integer>  randomList) {
        return randomList.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public void inputPrediction() {
        System.out.println("숫자를 입력해주세요 : ");
        String prediction = Console.readLine();
        setDigits(prediction);
    }

}
