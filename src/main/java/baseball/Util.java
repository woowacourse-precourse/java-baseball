package baseball;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Util {

    public String createAnswerString() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }

        StringBuilder sb = new StringBuilder();

        Iterator<Integer> iter = set.iterator();

        while (iter.hasNext()) {
            sb.append(iter.next());
        }

        return sb.toString();
    }

    public String createUserAnswerString() {
        String input = Console.readLine();

        Exception exception = new Exception();
        exception.createNumberInputException(input);

        return input;
    }
}
