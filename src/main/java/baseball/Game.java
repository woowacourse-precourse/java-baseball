package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int strike(List<Integer> user, List<Integer> computer) {
        int count = 0;
        for (int num = 0; num < user.size(); num++) {
            if (user.get(num).equals(computer.get(num))) count++;
        }
        return count;
    }

}

