package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Player {

    //컴퓨터의 랜덤 숫자 설정
    public void setRandNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        setNums(computer);
    }

    @Override
    public String toString() {
        return "Computer" + super.toString();
    }
}
