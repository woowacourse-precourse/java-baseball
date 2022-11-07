package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    List<Integer> targetNumber;

    public void generateTargetNumber(){
        while(targetNumber.size() < 3) {
            int randomNumber=Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }
    }

    public void startGame(){
        // TODO: 타겟 넘버 생성, 사용자 입력 실행 등 새 게임 시작
    }
}
