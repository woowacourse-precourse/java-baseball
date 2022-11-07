package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumber {

    List<Integer> randomNumberList = new ArrayList<>();

    public List<Integer> generateRandomNumber() {
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            inspectList(randomNumber);
        }

        return randomNumberList;
    }

    // 랜덤하게 생성한 수가 List에 존재하지 않을 경우에만 추가하는 메소드
    private void inspectList(int number) {
        if (!randomNumberList.contains(number)) {
            randomNumberList.add(number);
        }
    }

}
