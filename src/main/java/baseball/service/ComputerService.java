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

    public BallCountDto compareNumber(List<Integer> inputNumber, List<Integer> randomNumber) {
        int strikeCnt = 0, ballCnt = 0;

        for (int i = 0; i < inputNumber.size(); i++) {
            if (isStrike(inputNumber.get(i), randomNumber.get(i))) {
                strikeCnt++;
                continue;
            }
            if (isBall(inputNumber.get(i), randomNumber)) {
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
