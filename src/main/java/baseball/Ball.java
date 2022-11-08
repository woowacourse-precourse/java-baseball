package baseball;

import java.util.List;

public class Ball {
    public int count(List<String> computer, List<String> user) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if(checkBall(i, computer, user)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBall(int index, List<String> computer, List<String> user) {
        String nowComputer = computer.get(index);
        String nowUser = user.get(index);
        return !nowComputer.equals(nowUser) && computer.contains(nowUser);
    }
}
