package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Num_Generator {

    public static List<Integer> MakeComputerNum() { // 중복없는 3자리 난수 생성
        List<Integer> ComputerNum = new ArrayList<>();
        while (ComputerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!ComputerNum.contains(randomNumber)) {
                ComputerNum.add(randomNumber);
            }
        }
        return ComputerNum;
    }
}



