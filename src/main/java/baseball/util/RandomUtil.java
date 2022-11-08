package baseball.util;

import java.util.LinkedHashSet;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static Set<Integer> getRandomUniqueNumbers(int start, int end, int length) {
        Set<Integer> randomNumbers  = new LinkedHashSet<>();

        while(randomNumbers.size() != length) {
			randomNumbers.add(getNumber(start, end));
		}

		return randomNumbers;
    }

    public static int getNumber(int start, int end) {
        int randomNumber = Randoms.pickNumberInRange(start, end);
        return randomNumber;
    }
}
