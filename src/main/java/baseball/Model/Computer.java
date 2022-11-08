package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> createNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNum)) {
                numberList.add(randomNum);
            }
        }
        return numberList;
    }

    public List<Integer> checkStrikeBall(List<Integer> randomNumList, List<Integer> inputNumList) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumList.get(i) == inputNumList.get(i)) {
                strike++;
            } else if (randomNumList.contains(inputNumList.get(i))) {
                ball++;
            }
        }
        List<Integer> tmpResult = new ArrayList<>(List.of(strike, ball));
        return tmpResult;
    }

    public String getResult(List<Integer> strikeBallList) {
        int strike = strikeBallList.get(0);
        int ball = strikeBallList.get(1);
        String strResult = "낫싱";
        if (strike == 0) {
            if (ball != 0) {
                strResult = ball + "볼";
            }
        } else {
            if (ball != 0) {
                strResult = ball + "볼 " + strike + "스트라이크";
            } else {
                strResult = strike + "스트라이크";
            }
        }
        return strResult;
    }
}
