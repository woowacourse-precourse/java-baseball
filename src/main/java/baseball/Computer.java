package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static List<Integer> computer = new ArrayList<>();

    public static void generateRandomNumbers() {
        computer.clear();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static boolean checkScore(String input) {
        int ball = countBall(input);
        int strike = countStrike(input);

        if(strike == 3) {
            Result.printStrikeBallMessage(strike, ball);
            return true;
        }

        Result.printStrikeBallMessage(strike, ball);
        return false;
    }

    private static int countBall(String input) {
        int ball = 0;
        for(int i = 0; i < input.length(); i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if(computer.get(i) != num && computer.contains(num)) {
                ball++;
            }
        }
        return ball;
    }

    private static int countStrike(String input) {
        int strike = 0;
        for(int i = 0; i < input.length(); i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if(computer.get(i) == num) {
                strike++;
            }
        }
        return strike;
    }
}
