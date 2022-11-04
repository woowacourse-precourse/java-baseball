package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private List<Integer> randomNumbers = new ArrayList<>();

    /**
     * count 만큼의 1부터 9까지 서로 다른 수로 이루어진 랜덤 숫자 List를 반환하는 메소드
     * 최대 길이 9
     * @param count
     * @return
     */
    public List<Integer> getRandomNum(int count) {
        while (randomNumbers.size() < count && randomNumbers.size() < 9) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
