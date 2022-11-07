package baseball.domain;

import baseball.exception.ComputerException;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {


    public static List<Integer> computerRandomNumberList;

    public List<Integer> getComputerRandomNumberList() {
        return computerRandomNumberList;
    }

    public void setComputerRandomNumberList() {
        initComputerRandomNumberList();
        while (computerRandomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
            if (!computerRandomNumberList.contains(randomNumber)) {
                computerRandomNumberList.add(randomNumber);
            }
        }
    }

    public void initComputerRandomNumberList() {
        computerRandomNumberList = new ArrayList<>();
    }


}
