package baseball;

import java.util.List;

public class TargetNumber {
    public static final int TARGET_NUMBER_LENGTH = 3;

    private List<Integer> numberListByDigit;

    public static TargetNumber getRandomInstance() {
        // TODO 무작위의 TargetNumber Instance 반환
        return new TargetNumber(123);
    }

    public TargetNumber(int number) throws IllegalArgumentException {
        // TODO number를 digit 별로 나눠서 numberListByDigit에 저장하기
        //  number의 길이가 TARGET_NUMBER_LENGTH를 넘을 경우,
        //  같은 숫자가 있을 경우 IllegalArgumentException을 발생시킨다.
    }

    public int toInt() {
        return 0;
    }

    public BallStrikeResult compareTo(TargetNumber oth) {
        // TODO 해당 값과 oth를 비교하여 같은 수가 같은 자리에 있으면 스트라이크,
        //  다른자리에 있으면 볼로 하여 그 개수를 BallStrikeResult로 반환한다.
        return new BallStrikeResult(0, 0);
    }
}
