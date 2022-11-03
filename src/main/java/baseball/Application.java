package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGame();
    }

    public static void playGame() {
        List<Integer> computer = generateNumber();
        guessNumber();

    }


    public static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void guessNumber() {

    }

    public static boolean validateNumber() {

        return true;
    }


}
