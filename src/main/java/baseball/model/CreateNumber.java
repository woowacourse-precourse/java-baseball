package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateNumber {
    List<Integer> randomNumbers = new ArrayList<>();
    //랜덤 값을 생성
    public List<Integer> createRandomNumber(){
        while (randomNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
