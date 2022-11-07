package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateNumber() {
        initNumbers();
        while(numbers.size() < Constants.NUMBER_LENGTH) {
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
        return Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
    }

    public void initNumbers() {
        numbers.clear();
    }

    public Result compareNumber(String guessNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < Constants.NUMBER_LENGTH; i++) {
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
