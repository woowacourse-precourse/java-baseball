package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        sendMassage(GameMassage.START_MASSAGE);
        List<Integer> computer = randomThreeDigit();

    }

    private static void sendMassage(GameMassage massage){
        System.out.print(massage.getMassage());
    }

    private static List<Integer> randomThreeDigit() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digits.contains(randomNumber)) {
                digits.add(randomNumber);
            }
        }
        return digits;
    }
}
