package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        comNumber();
    }

    // 컴퓨터의 서로 다른 숫자 3개 저장
    public static List comNumber() {
        List<Integer> comList = new ArrayList<>();

        for (int i=0; i<3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);

            if(!comList.contains(num)) {
                comList.add(num);
            } else {
                i--;
            }
        }

        return comList;
    }
}
