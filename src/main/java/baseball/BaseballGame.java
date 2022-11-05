package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public List<Integer> getUserNumber() {
        String userInput = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            userNumber.add(Character.getNumericValue(c));
        }
        return userNumber;
    }

    public boolean isValidNumber(String userInput) {
        Set<Character> sameNumberCheck = new HashSet<>();
        if (userInput.length() != 3) return false;
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) return false;
            if (c == '0') return false;
            sameNumberCheck.add(c);
        }
        return sameNumberCheck.size() == 3;
    }
}