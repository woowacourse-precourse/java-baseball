package baseball.Service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    public void gameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameInProgress(){
        List<Integer> computer = pickThreeNumbers();

    }

    public List<Integer> pickThreeNumbers(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
