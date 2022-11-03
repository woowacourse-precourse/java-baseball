package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Character> computerNumber;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void initComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            Character randomNumber = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public static int checkStrike(String userInput) {
        int strikeCount = 0;

        for (int place = 0; place < userInput.length(); place++) {
            Character computerNum = computerNumber.get(place);
            Character userNum = userInput.charAt(place);

            if(computerNum.equals(userNum)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static int checkBall(String userInput) {
        int ballCount = 0;

        for (int place = 0; place < userInput.length(); place++) {
            Character computerNum = computerNumber.get(place);
            Character userNum = userInput.charAt(place);

            if(!computerNum.equals(userNum) && computerNumber.contains(userNum)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public static boolean checkNothing(String userInput) {
        for (Character userNumber : userInput.toCharArray()) {
            if (computerNumber.contains(userNumber)) {
                return false;
            }
        }

        return true;
    }

    public static void validateUserInput(String userInput) {
        try {
            validateUserInputSize(userInput);
            validateUserInputForm(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("입력 형식에 맞지 않습니다, 프로그램을 종료합니다.");
            throw e;
        }
    }

    public static void validateUserInputSize(String userInput) {
        if(userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static Exception validateUserInputForm(String userInput) {
        for(Character userNumber : userInput.toCharArray()) {
            if(!('1' <= userNumber && userNumber <='9')) {
                throw new IllegalArgumentException();
            }
        }
        return null;
    }
}
