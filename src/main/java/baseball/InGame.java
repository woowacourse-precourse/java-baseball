package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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
        isInteger(input);
        if (input.length() > 3 || input.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
        duplicateNumber(input);
    }

    private static void duplicateNumber(String input) {
        int intInput = Integer.parseInt(input);
        List<Integer> numList = List.of(intInput);
        if(numList.size() != numList.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

    private static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e); // IllegalArgumentException 이 아닌 NumberFormatException 을 던지는 이슈있음
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
