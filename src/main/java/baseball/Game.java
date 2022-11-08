package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    List<Integer> numbersPickedByComputer;
    List<Integer> numbersPickedByUser;
    int strike=0;
    int ball=0;

    public void computerSelectThreeNumbers() {
        numbersPickedByComputer = new ArrayList<>();
        while (numbersPickedByComputer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbersPickedByComputer.contains(randomNumber)) {
                numbersPickedByComputer.add(randomNumber);
            }
        }
    }

    public void validateInputNumber(String numberString) throws IllegalArgumentException {
        if (!validateLengthOfInputString((numberString)) ||
                !validateTypeOfInputString(numberString) ||
                !validateUniquenessOfEachCharacter(numberString)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateLengthOfInputString(String numberString) {
        if (numberString.length() == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateTypeOfInputString(String numberString) {
        for (int i = 0; i < numberString.length(); i++) {
            char numberCharacter = numberString.charAt(i);
            if (numberCharacter < '1' || numberCharacter > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean validateUniquenessOfEachCharacter(String numberString) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < numberString.length(); i++) {
            char numberCharacter = numberString.charAt(i);
            if (set.contains(numberCharacter)) {
                return false;
            } else {
                set.add(numberCharacter);
            }
        }
        return true;
    }

    public void userSelectThreeNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numberString = readLine();
        validateInputNumber(numberString);
        numbersPickedByUser = new ArrayList<>();
        for (int i = 0; i < numberString.length(); i++) {
            numbersPickedByUser.add(Character.getNumericValue(numberString.charAt(i)));
        }
    }

    public void countMatchingNumbers() {
        for (int i = 0; i < numbersPickedByComputer.size(); i++) {
            if (numbersPickedByComputer.get(i) == numbersPickedByUser.get(i)) {
                strike++;
            } else if (numbersPickedByComputer.contains(numbersPickedByUser.get(i))) {
                ball++;
            }
        }
    }

    public boolean printResultOfGame() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        } else if(ball !=0 && strike !=0) {
            result = ball + "볼 " + strike + "스트라이크";
        } else if (ball == 0) {
            result = strike + "스트라이크";
        } else {
            result = ball + "볼";
        }
        System.out.println(result);

        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean decideRestartOrQuit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int restart = Integer.parseInt(readLine());
            if (!(restart == 1 || restart == 2)) {
                throw new IllegalArgumentException();
            }
            if (restart == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void initializeBallCount() {
        strike = 0;
        ball = 0;
    }


}
