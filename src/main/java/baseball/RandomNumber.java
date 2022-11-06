package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    NumberVO numberVO = new NumberVO();
    public void createRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        numberVO.setRandomNumber(computer);
        System.out.println("난수:"+numberVO.getRandomNumber()+":");

    }

}
