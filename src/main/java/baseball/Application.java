package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        boolean allCorrect = false;

        while (!allCorrect) {
            String userAnswer = Console.readLine();
            for (int i = 0; i < 3; i++) {
                if (userAnswer.charAt(i) - '0' != computer.get(i)) {
                    allCorrect = false;
                    System.out.println("not correct");
                    break;
                }
                allCorrect = true;
            }
        }
        System.out.println("correct");
    }


}