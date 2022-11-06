package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 컴퓨터의 수를 생성하고, 사용자의 수와 비교하는 등 컴퓨터의 수와 관련된 책임을 갖는 클래스
 */
public class ComputerManager {
    private List<Integer> computerNumbers;

    /**
     * 컴퓨터매니저 클래스가 가진 랜덤 수를 초기화하고,
     * 랜덤한 수를 생성하고 넣어주는 함수
     */
    public void generateRandomNumber() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computerNumbers.contains(randomNumber)){
                computerNumbers.add(randomNumber);
            }
        }
    }
}
