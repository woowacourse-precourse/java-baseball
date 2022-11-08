package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class BaseballNumbers {
    public static final int SIZE = 3;
    private final List<BaseballNumber> numbers;

    private BaseballNumbers(List<BaseballNumber> numbers) {
        this.numbers = numbers;
    }

    public static BaseballNumbers getUserNumbers(String inputNumbers){
        List<BaseballNumber> userNumbers = Arrays.stream(inputNumbers.split(""))
                .map(digit -> BaseballNumber.valueOf(digit))
                .collect(Collectors.toList());
        validateSize(userNumbers);
        validateDuplication(userNumbers);
        return new BaseballNumbers(userNumbers);
    }

    public static BaseballNumbers getComputerNumbers(){
        List<BaseballNumber> computerNumbers = getRandomNumbers();
        return new BaseballNumbers(computerNumbers);
    }

    private static void addDistinctRandomNumber(List<BaseballNumber> randomNumbers, BaseballNumber randomNumber){
        if(!randomNumbers.contains(randomNumber)){
            randomNumbers.add(randomNumber);
        }
    }

    public static List<BaseballNumber> getRandomNumbers(){
        List<BaseballNumber> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < SIZE){
            int randomInt = Randoms.pickNumberInRange(BaseballNumber.MIN_NUMBER, BaseballNumber.MAX_NUMBER);
            addDistinctRandomNumber(randomNumbers, BaseballNumber.valueOf(randomInt));
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

    public RoundResult compareTo(BaseballNumbers otherNumbers){
        Integer ballCount = 0;
        Integer strikeCount = 0;
        for(int index = 0; index < BaseballNumbers.SIZE; index++){
            BaseballNumber otherDigit = otherNumbers.numbers.get(index);
            BaseballNumber myDigit = this.numbers.get(index);
            if(myDigit.equals(otherDigit)){
                strikeCount++;
                continue;
            }
            if(this.numbers.contains(otherDigit)){
                ballCount++;
            }
        }
        return RoundResult.of(ballCount, strikeCount);
    }
}
