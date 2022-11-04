package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    public static final int SIZE = 3;
    List<BaseballNumber> numbers = new ArrayList<>();

    private BaseballNumbers(List<BaseballNumber> numbers) {
        this.numbers = numbers;
    }

    public static BaseballNumbers getComputerNumbers(){
        List<BaseballNumber> computerNumbers = getRandomNumbers();
        return new BaseballNumbers(computerNumbers);
    }

    private static void addRandomNumber(List<BaseballNumber> randomNumbers, BaseballNumber randomNumber){
        if(!randomNumbers.contains(randomNumber)){
            randomNumbers.add(randomNumber);
        }
    }

    private static List<BaseballNumber> getRandomNumbers(){
        List<BaseballNumber> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < SIZE){
            int randomInt = Randoms.pickNumberInRange(BaseballNumber.MIN_NUMBER, BaseballNumber.MAX_NUMBER);
            BaseballNumber randomNumber = BaseballNumber.valueOf(randomInt);
            addRandomNumber(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }
}
