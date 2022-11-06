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
}
