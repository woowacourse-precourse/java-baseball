package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Input {
    static List<Integer> computerRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(random)) {
                computer.add(random);
            }
        }
        return computer;
    }
    static String userNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        return Console.readLine();
    }

}
