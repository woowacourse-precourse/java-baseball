package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Ball {
    private Integer number;

    public Ball() { // Default 생성자
    }

    public void generate() {
        this.number = Randoms.pickNumberInList(List.of(1, 9));
    }

    public Integer getNumber() {
        return this.number;
    }
}
