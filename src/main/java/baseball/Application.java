package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Game.play;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = true;

        while(isContinue) {
            List<String> computerNumber = getComputerNumber();

            play(computerNumber);
        }
    }

    private static ArrayList<String> getComputerNumber() {
        ArrayList<String> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }

        return computerNumber;
    }
}
