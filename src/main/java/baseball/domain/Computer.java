package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;

    private List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
    }

    public void generateNumber() {
        initNumbers();
        while(numbers.size() < NUMBER_LENGTH) {
            int number = getRandomNumber();
            addIfNotUsed(number);
        }
    }

    public void addIfNotUsed(int number) {
        if(!numbers.contains(number)){
            numbers.add(number);
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void initNumbers() {
        numbers.clear();
    }

    public Result compareNumber(String guessNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < NUMBER_LENGTH; i++) {
            int number = Character.getNumericValue(guessNumber.charAt(i));

            if(isStrike(number, i)){
                strikeCount++;
            }
            else if(isBall(number)){
                ballCount++;
            }
        }
        return new Result(ballCount, strikeCount);
    }

    public boolean isBall(int number){
        return numbers.contains(number);
    }

    public boolean isStrike(int number, int index){
        return numbers.get(index) == number;
    }
}
