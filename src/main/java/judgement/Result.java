package judgement;

import java.util.List;


public class Result {

    public static int compareNumberComputerWithUser(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static int strikeCount(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public static String referee(List<Integer> computer, List<Integer> user) {
        int sameNumberCount = compareNumberComputerWithUser(computer, user);
        int strikeCount = strikeCount(computer, user);
        int ballCount = sameNumberCount - strikeCount;

        if (sameNumberCount == 0) {
            return "낫싱";
        } else if (strikeCount == 0) {
            return ballCount + "볼";
        } else if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        return ballCount + "볼 " + strikeCount + "스트라이크";
    }
}
