package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static List<Character> computerNumber;
    static String errorMessage = "입력 형식에 맞지 않습니다 프로그램을 종료합니다.";
    static String startMessage = "숫자 야구 게임을 시작합니다.";
    static String inputMessage = "숫자를 입력해 주세요: ";
    static String threeStrikeMessage = "3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static Scanner scanner = new Scanner(System.in);

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
            System.out.println(errorMessage);
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

    public static String giveHint(String userInput) {
        int ballCount = 0;
        int strikeCount = 0;
        String hintMessage = "";

        validateUserInput(userInput);
        checkUserInputIsThreeStrike(userInput);

        if(!checkNothing(userInput)) {
            ballCount = checkBall(userInput);
            strikeCount = checkStrike(userInput);

        }
        hintMessage = createHintMessage(ballCount, strikeCount);

        return hintMessage;
    }

    public static String createHintMessage(int ballCount, int strikeCount) {
        StringBuilder hintMessageBuilder = new StringBuilder();
        String hintMessage;

        if(ballCount > 0) {
            hintMessageBuilder.append(ballCount).append("볼").append(" ");
        }

        if (strikeCount > 0) {
            hintMessageBuilder.append(strikeCount).append("스트라이크");
        }

        if(ballCount == 0 && strikeCount == 0) {
            hintMessageBuilder.append("낫싱");
        }

        hintMessage = hintMessageBuilder.toString();
        return hintMessage;
    }

    public static void checkUserInputIsThreeStrike(String userInput) {
        int strikeCount = checkStrike(userInput);
        System.out.println(threeStrikeMessage);
    }

    public static String readeUserInput() {
        String userInput = scanner.nextLine();
        return userInput;
    }
}
