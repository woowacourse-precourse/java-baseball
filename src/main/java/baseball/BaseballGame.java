package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

    public int checkStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (Objects.equals(computerNumber.get(index), userNumber.get(index))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int checkBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int ballCount = 0;
        for (int index = 0; index < 3; index++) {
            if (Objects.equals(computerNumber.get(index), userNumber.get(index))) {
                continue;
            }
            if (computerNumber.contains(userNumber.get(index))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public String getResult(int strike, int ball) {
        StringBuilder result = new StringBuilder();
        if (ball != 0) {
            result.append(ball).append("볼 ");
        }
        if (strike != 0) {
            result.append(strike).append("스트라이크 ");
        }
        if (ball == 0 && strike == 0) {
            result.append("낫싱");
        }
        return String.valueOf(result).trim();
    }
}