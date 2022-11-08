package baseball.utils;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private int numberOfDigit;
    private Game game;

    public RandomNumber(Game game, final int NUMBER_OF_DIGIT) {
        this.game = game;
        this.numberOfDigit = NUMBER_OF_DIGIT;
    }

    public void createRandomNum() {
        List<Integer> randomNumList = new ArrayList<>();

        while (true) {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);

            if(!randomNumList.contains(pickedNumber)){
                randomNumList.add(pickedNumber);
            }
            if (randomNumList.size() == numberOfDigit && isValidateDigitNum(randomNumList)) {
                break;
            }
        }

        int randomNum = numListToIntValue(randomNumList);

        game.setRandomNumber(randomNum);
    }

    public int numListToIntValue(List<Integer> numList) {
        int listSize = numList.size();
        int resultNum = 0;

        for (int i = 0; i < listSize; i++) {
            resultNum += numList.get(i) * Math.pow(10, listSize - i - 1);
        }

        return resultNum;
    }

    public boolean isValidateDigitNum(List<Integer> numList) {
        int firstDigit = numList.get(0);

        if (firstDigit == 0) {
            return false;
        }
        return true;
    }
}
