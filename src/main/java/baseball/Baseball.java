package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class Baseball {

    private static List<Integer> computer;

    public Baseball() {
        computer = new ArrayList<>();
    }

    private void printInit() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
