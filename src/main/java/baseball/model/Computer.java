package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumberList = new ArrayList<>();

    public void randomGenerate() {
        while(computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumberList() {
        return computerNumberList;
    }

    // 테스트를 위한 컴퓨터 숫자 수정 메서드
    public void setComputerNumberList(List<Integer> computerNumberList) {
        this.computerNumberList = computerNumberList;
    }
}
