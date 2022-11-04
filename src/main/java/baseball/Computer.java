package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    List<Integer> randomNumber = new ArrayList<>();
    Map<String, Integer> ballAndStrike = new HashMap<>();

    // 세자리 난수 설정
    public List<Integer> setRandomNumber() {
        while(randomNumber.size() < 3){
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(pickedNumber)){
                randomNumber.add(pickedNumber);
            }
        }
        return randomNumber;
    }
}
