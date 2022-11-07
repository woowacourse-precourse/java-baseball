package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumber {

    // 랜덤으로 생성된 숫자를 저장하기 위한 Integer형 리스트
    List<Integer> randomNumberList = new ArrayList<>();

    // 랜덤한 숫자를 생성하기 위한 generateRandomNumber 메소드
    public List<Integer> generateRandomNumber() {
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            inspectList(randomNumber);
        }

        return randomNumberList;
    }

    // 랜덤생성 한 수가 List에 존재하지 않을 경우에만 추가하는 메소드
    private void inspectList(int number) {
        if (!randomNumberList.contains(number)) {
            randomNumberList.add(number);
        }
    }

}
