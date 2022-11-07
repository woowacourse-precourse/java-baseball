import static baseball.common.Constants.END_NUMBER_RANGE;
import static baseball.common.Constants.MAX_NUMBER_COUNT;
import camp.nextstep.edu.missionutils.Randoms;
    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER_RANGE, END_NUMBER_RANGE);
    }
