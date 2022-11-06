package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Controller {
    Controller() {}

    void start() {

    }

    String compareNumber(int humannumber, int computernumber) {
        return  "";
    }

    String compareEachNumber(int humanfirst, int humansecond, int humanthird, int computerfirst, int computersecond, int computerthird) {
        return  "";
    }

    String randomNumber() {
        String result = "";
        int randomnumber = 0;

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        randomnumber = computer.get(0) *100 + computer.get(1) * 10 + computer.get(2);
        result = Integer.toString(randomnumber);

        return result;
    }
}
