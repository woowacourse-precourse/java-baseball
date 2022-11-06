package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int NUMBER_SIZE = 3;
    private final List<Integer> computerNumberList;

    public Computer() {
        this.computerNumberList = createNumber();
    }

    public List<Integer> getComputerNumberList() {
        return computerNumberList;
    }

    // 컴퓨터가 임의의 수 3개를 선택해서 반환하는 기능
    private List<Integer> createNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
