package baseball.randomgenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 난수를 생성하는 기능에 관련된 클래스입니다.
 * @version 1.0.0
 * @author Cho MinHo
 */
public class RandomNumberGenerator {

    /**
     * 3개의 난수를 가지는 List를 생성하는 기능을 담당하는 메서드입니다.
     * 각 난수는 1에서 9까지의 범위를 가지며, 모두 다른 수로 구성됩니다.
     *
     * @return 3개의 서로 다른 난수를 가진 Integer List
     */
    public static List<Integer> getRandomNumList() {
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }

}
