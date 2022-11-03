package features;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Player {

    // 플레이어 기능 : 상대방(컴퓨터)의 수를 생성
    public static List<Integer> createComputerNumber(){

        List<Integer> computer = new ArrayList<>();

        while (computer.size()<=3){
            computer.add(Randoms.pickNumberInRange(1, 9));
        }

        return computer;
    }
}
