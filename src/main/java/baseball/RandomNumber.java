package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public static List<Integer> gameRandomNumber(){
        List<Integer> randomNumberList = createRandomNumber(); // 난수 생성
        System.out.println("난수:" + randomNumberList + ":");
        return randomNumberList;
    }

    public static List<Integer> createRandomNumber(){

        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
