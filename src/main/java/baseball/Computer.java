package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    List<Integer> computerNumberList;

    Computer() {
        this.printStarting();
        computerNumberList = this.makeNumberList();
    }

    void printStarting() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    List<Integer> makeNumberList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computerNumberList = addNumberIfNotList(computerNumberList, randomNumber);
        }
        return computerNumberList;
    }

    List<Integer> addNumberIfNotList(List<Integer> computerNumberList, int randomNumber) {
        if (!computerNumberList.contains(randomNumber)) {
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }
}
