package baseball.compute;

import java.util.*;

public class compare {
    public int isStrike(List<Integer> Answer, List<Integer> UsersAnswer) {
        int count = 0;
        for(int i = 0 ; i < 3; i++) {
            int a = Answer.get(i);
            int u = UsersAnswer.get(i);
            if (a == u) {
                count++;
            }
        }
        return count;
    }
    public int isBall(List<Integer> Answer, List<Integer> UsersAnswer) {
        int count = 0;
        for(int i = 0 ; i < 3; i++) {
            int u = UsersAnswer.get(i);
            if (Answer.contains(i)) {
                count++;
            }
        }
        return count;
    }
}
