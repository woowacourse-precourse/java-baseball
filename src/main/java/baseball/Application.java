package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
//        기능1. 컴퓨터 숫자선정

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            final int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.print(randomNumber);
            }
        }


    }
}
