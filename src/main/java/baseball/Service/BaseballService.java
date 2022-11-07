package baseball.Service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    private static final int NUMBER_SIZE=3;

    //랜덤 숫자 생성
    public List<String> createRandomNumber(){

        List<String> computerNumber = new ArrayList<>();

        for(int i=0; i<NUMBER_SIZE; i++) {
            computerNumber.add(Integer.toString(Randoms.pickNumberInRange(1, 9)));
        }

        return computerNumber;
    }


}
