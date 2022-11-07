package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        List<Integer> computerNumber = Utils.pickComputerNumber();

        String line = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            userNumber.add(Character.getNumericValue(line.charAt(i)));
        }

        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            // strike 확인
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                // ball 확인
                ball++;
            }
        }
    }
}
