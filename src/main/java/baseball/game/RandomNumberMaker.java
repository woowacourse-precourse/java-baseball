package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker implements NumberMaker {
    private final int minNum;
    private final int maxNum;

    public RandomNumberMaker(int min, int max) {
        this.minNum = min;
        this.maxNum = max;
    }

    @Override
    public Integer generate() {
        Integer result = Randoms.pickNumberInRange(minNum, maxNum);
        System.out.println("result = " + result);
        return result;
    }
}
