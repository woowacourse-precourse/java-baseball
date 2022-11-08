package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.constants.*;

public class Computer {


    /**
     * 컴퓨터가 생성한 난수의 각 자리수를 List에 담아 Return하는 메소드
     * @return 생성한 난수 각 자리수를 담은 List
     */
    public List<Integer> getRandomNumber(){
        List<Integer> randomList = new ArrayList<>();

        while(randomList.size() < NUMBER_LIMIT_LENGTH){
            int random = Randoms.pickNumberInRange(START_NUMBER,END_NUMBER);

            if(!randomList.contains(random)){
                randomList.add(random);
            }
        }
        return randomList;
    }
}
