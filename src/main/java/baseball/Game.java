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

    public static int ball(List<Integer> user, List<Integer> computer) {
        int count = 0;
        List<Integer> tempUser = new ArrayList<>();
        for (int num = 0; num < user.size(); num++) {
            tempUser.addAll(user);
            tempUser.remove(user.get(num));

            if (tempUser.contains(computer.get(num))) count++;
            tempUser.removeAll(user);
        }

        return count;
    }

    public static boolean nothing(int strikeCounter, int ballCounter){
        return strikeCounter == 0 && ballCounter == 0;
    }
}

