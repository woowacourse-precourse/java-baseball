package baseball.domain;

import baseball.util.RandomNumbers;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private BaseballNumbers correctBaseballNumbers; // 정답값

    public void setCorrectBaseballNumbersRandom(){
        List<Integer> randomNumberList = RandomNumbers.createRandomIntListWithoutDuplication(1, 9);
        List<BaseballNumber> randomBaseballNumberList = new ArrayList<>();
        for(int i=0; i<randomNumberList.size();i++){// BaseballNumberList 형태로 변환
            BaseballNumber baseballNumber = new BaseballNumber(randomNumberList.get(i));
            randomBaseballNumberList.add(baseballNumber);
        }

        correctBaseballNumbers = new BaseballNumbers(randomBaseballNumberList);
    }

    public BaseballNumbers getCorrectBaseballNumbers() {
        return correctBaseballNumbers;
    }
}
