package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Ball {

    public static int strike(List<Integer> user, List<Integer> computer) {
        int count = 0;
        for (int num = 0; num < user.size(); num++) {
            if (user.get(num).equals(computer.get(num))) count++;
        }
        return count;
    }

    public static int ball(List<Integer> user, List<Integer> computer) {
        int count = 0;
        List<Integer> tmp = new ArrayList<>();
        for (int num = 0; num < user.size(); num++) {
            tmp.addAll(user);
            tmp.remove(user.get(num));

            if (tmp.contains(computer.get(num))) count++;
            tmp.removeAll(user);
        }

        return count;
    }

    public static boolean nothing(int strike, int ball){
        return strike == 0 && ball == 0;
    }


}
