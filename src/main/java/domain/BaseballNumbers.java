package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private int getStrikeCount(BaseballNumbers otherNumbers){
        return (int) IntStream.range(0,BaseballNumbers.SIZE)
                .filter(index -> otherNumbers.numbers.get(index).equals(numbers.get(index)))
                .count();
    }

    private int getBallCount(BaseballNumbers otherNumbers){
        return (int) IntStream.range(0, BaseballNumbers.SIZE)
                .filter(index -> numbers.contains(otherNumbers.numbers.get(index)))
                .filter(index -> !numbers.get(index).equals(otherNumbers.numbers.get(index)))
                .count();
    }

    public RoundResult compareTo(BaseballNumbers otherNumbers){
        int strikeCount = getStrikeCount(otherNumbers);
        int ballCount = getBallCount(otherNumbers);
        return RoundResult.of(ballCount, strikeCount);
    }
}
