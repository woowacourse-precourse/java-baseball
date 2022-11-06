package baseball.gameUtil;

import baseball.exception.ExceptionCode;
import baseball.exception.GameException;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameUtils {
    public List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public void validateRandomNumber(List<Integer> number) {
        if(number.size() != 3) {
            throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
        }
        for(Integer n : number) {
            if(n <= 0 || n > 9) {
                throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
            }
        }
        Set<Integer> set = new HashSet<>(number);
        if(set.size() != 3) {
            throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
        }
    }

}
