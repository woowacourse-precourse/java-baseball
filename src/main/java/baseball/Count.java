package baseball;

import java.util.List;

public class Count {
    public static int Strike(List<Integer> opponent, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < Number.NUMBERS_SIZE; i++) {
            int opponentNumber = opponent.get(i);
            int userNumber = user.get(i);
            strike += compareNumber(opponentNumber, userNumber);
        }
        return strike;
    }

    public static int Ball(List<Integer> opponent, List<Integer> user) {
        int ball = Count.countOverlapNumbers(opponent, user)
                - Count.Strike(opponent, user);
        return ball;
    }

    public static int countOverlapNumbers(List<Integer> opponent, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < Number.NUMBERS_SIZE; i++) {
            int userNumber = user.get(i);
            count += containNumber(opponent, userNumber);
        }
        return count;
    }

    public static int compareNumber(int opponent, int user) {
        if (opponent == user) {
            return 1;
        }
        return 0;
    }

    public static int containNumber(List<Integer> opponent, int number) {
        if (opponent.contains(number)) {
            return 1;
        }
        return 0;
    }
}
