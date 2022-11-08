package baseball;

import java.util.List;

public class GetGameResult {
    public static int countStrike(List<Integer> user, List<Integer> computer){
        int strike = 0;
        for(int i = 0; i < user.size(); i++) {
            if (computer.indexOf(user.get(i)) == i) {
                strike++;
            }
        }
        return strike;
    }
    public static int countBall(List<Integer> user, List<Integer> computer){
        int ball = 0;
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i)) && computer.indexOf(user.get(i)) != i) {
                ball++;
            }
        }
        return ball;
    }
}
