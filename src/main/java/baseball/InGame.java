package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InGame {

    public void gameStart() {
        System.out.println("숫자를 입력해 주세요 : ");
        String input = readLine();

        validateInGame(input);
        newRandomNumber();
    }

    public void validateInGame(String input) {
        isNumeric(input);
    }

    private static void isNumeric(String input) {
        try {
            int intInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void newRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        Application.randomNum = computer;
    }
}
