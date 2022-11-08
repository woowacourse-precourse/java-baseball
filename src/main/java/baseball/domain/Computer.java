package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> ballCounts = new ArrayList<>();

    void initRandomNumbers() {
        this.clearRandomNumbers();
        while (this.ballCounts.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.ballCounts.contains(randomNumber)) {
                this.ballCounts.add(randomNumber);
            }
        }
    }

    List<Integer> getBallCounts() {
        return this.ballCounts;
    }

    // 게임 종료 시 모든 엘리먼트를 삭제
    void clearRandomNumbers() {
        this.ballCounts.clear();
    }

    // Debug 용 출력 메소드
    void getCounts() {
        for (int i = 0; i < this.ballCounts.size(); i++) {
            System.out.print(this.ballCounts.get(i) + " ");
        }
        System.out.println();
    }
}
