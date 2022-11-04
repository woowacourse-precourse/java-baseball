package baseball.util;

import java.util.LinkedHashSet;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public Set<Integer> getRandomNumbers(int start, int end, int length) {
        Set<Integer> randomNumbers  = new LinkedHashSet<>();

        while(randomNumbers.size() != length) {
			randomNumbers.add(getUniqueNumber(start, end));
		}

		return randomNumbers;
    }

    public int getUniqueNumber(int start, int end) {
        int randomNumber = Randoms.pickNumberInRange(start, end);
        return randomNumber;
    }
}
