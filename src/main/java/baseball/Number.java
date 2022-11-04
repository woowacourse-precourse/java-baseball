package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Number {
    public void setRandomNumbers() {
        Set<Integer> NumberSet = new HashSet<>();
        while (NumberSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!NumberSet.contains(randomNumber)) {
                NumberSet.add(randomNumber);
            }

        }
    }

    public String getInputNumber() {
        return readLine();
    }


}
