package baseball.model;

import java.util.Arrays;
import java.util.List;

public class CompareInputNumber {
    public List<Integer> compareRandomandUser(List<Integer> random_num, List<Integer> user_num) {
        int count = 0;
        for (Integer number : user_num) {
            if (random_num.contains(number))
                count++;
        }
        int strike = countStrike(random_num, user_num);
        return Arrays.asList(count - strike, strike);
    }

    public int countStrike(List<Integer> random_num, List<Integer> user_num) {
        int count = 0;
        for (int i = 0; i < user_num.size(); i++) {
            if (random_num.get(i).equals(user_num.get(i)))
                count++;
        }
        return count;
    }
}
