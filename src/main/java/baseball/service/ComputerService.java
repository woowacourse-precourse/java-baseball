package baseball.service;

import baseball.dto.BallCountDto;
import baseball.dto.RandomNumberListDto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {

    public List<Integer> getRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addRandomNumber(randomNumberList, randomNumber);
        }
        return randomNumberList;
    }

    public BallCountDto compareNumber(List<Integer> inputNumber) {
        int strikeCnt = 0, ballCnt = 0;
        List<Integer> randomNumber = getRandomNumber();

        for (int i = 0; i < inputNumber.size(); i++) {
            if (isStrike(inputNumber.indexOf(i), randomNumber.indexOf(i))) {
                strikeCnt++;
            }
            if (isBall(inputNumber.indexOf(i), randomNumber)) {
                ballCnt++;
            }
        }
        return new BallCountDto(strikeCnt, ballCnt);
    }

    private boolean isStrike(Integer inputNumberElement, Integer randomNumberElement) {
        return inputNumberElement.equals(randomNumberElement);
    }

    private boolean isBall(Integer inputNumberElement, List<Integer> randomNumber) {
        return randomNumber.contains(inputNumberElement);
    }


    public void addRandomNumber(List<Integer> randomNumberList, int randomNumber) {
        if (!randomNumberList.contains(randomNumber)) {
            randomNumberList.add(randomNumber);
        }
    }
}
