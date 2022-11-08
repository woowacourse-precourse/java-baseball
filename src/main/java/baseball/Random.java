package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Random {
    int randomNumber = 0;

    public void randomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
//                    System.out.print(randomNumber); //컴퓨터 입력값 출력
            }
        }
        System.out.println(computer);  //컴퓨터 입력값 리스트 출력
    }
}