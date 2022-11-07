package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> answer;

    public void makeRandomNum() {
        List<Integer> number = new ArrayList<>();
        while (number.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!number.contains(randomNumber)){
                number.add(randomNumber);
            }
        }
        answer = number;
    }

    public boolean checkIillgal(String num) { //4자리 중복없이
        return false;
    }

    public String getResult(String num) { //스트라이크 낫싱 볼
        return null;
    }
}
