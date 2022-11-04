package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballNumbers {
    public static final int SIZE = 3;
    List<BaseballNumber> numbers = new ArrayList<>();

    private BaseballNumbers(List<BaseballNumber> numbers) {
        this.numbers = numbers;
    }

    public static BaseballNumbers getUserNumbers(String inputNumbers){
        List<BaseballNumber> userNumbers = new ArrayList<>();
        IntStream stream = Arrays.stream(inputNumbers.split("")).mapToInt(Integer::parseInt);
        stream.forEach(digit-> {
            userNumbers.add(BaseballNumber.valueOf(digit));
        });
        validateSize(userNumbers);
        validateDuplication(userNumbers);
        return new BaseballNumbers(userNumbers);
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

    private static void validateSize(List<BaseballNumber> userNumbers){
        if(userNumbers.size() != SIZE){
            throw new IllegalArgumentException("3자리의 숫자를 입력해야합니다.");
        }
    }

    private static void validateDuplication(List<BaseballNumber> userNumbers){
        if(userNumbers.stream().distinct().count() != SIZE){
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야합니다.");
        }
    }
}
