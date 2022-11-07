package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //랜덤한 숫자 3개 뽑기

        List<Integer> computerNumber = new ArrayList<Integer>();

        for(int i=0; i<3; i++) {
            computerNumber.add(Randoms.pickNumberInRange(1, 9));
        }

    }
}
