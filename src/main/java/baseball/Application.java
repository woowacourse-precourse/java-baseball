package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(getGuideMessage(null));
        while (true) {
            String computerNumber = generateComputerNumber();
            startGame(computerNumber);
            System.out.println(getGuideMessage("finished"));

            String continueGame = Console.readLine();
            if (!checkRestartGame(continueGame)) {
                break;
            }
        }

    }

    public static String getGuideMessage(String userStatus) {
        if (userStatus == null) {
            return "숫자 야구 게임을 시작합니다.";
        } else {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        }
    }

    public static String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static boolean checkNumberLength(String userNumber) {
        return userNumber.length() == 3;
    }

    public static boolean checkOnlyNumber(String userNumber) {
        try {
            Double.parseDouble(userNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean checkNotContainZero(String userNumber) {
        return !userNumber.contains("0");
    }

    public static boolean checkNotDuplication(String userNumber) {
        for (int index = 0; index < userNumber.length(); index++) {
            if (userNumber.indexOf(userNumber.charAt(index)) != index) {
                return false;
            }
        }
        return true;
    }

    public static void checkIllegalArgumentException(String userNumber) {
        if (!checkNumberLength(userNumber)) {
            throw new IllegalArgumentException("입력이 세 자리 수가 아닙니다!");
        }
        if (!checkOnlyNumber(userNumber)) {
            throw new IllegalArgumentException("입력이 숫자로만 이루어지지 않았습니다!");
        }
        if (!checkNotContainZero(userNumber)) {
            throw new IllegalArgumentException("입력에 0이 포함되어 있습니다!");
        }
        if (!checkNotDuplication(userNumber)) {
            throw new IllegalArgumentException("입력에 같은 수가 중복되었습니다!");
        }

    }

    public static String convertArrayListToString(List<Integer> numberList) {
        StringBuilder sb = new StringBuilder();

        for (int number : numberList) {
            sb.append(number);
        }
        return sb.toString();
    }

    public static String generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return convertArrayListToString(computerNumber);
    }

    public static List<Character> convertStringToArrayList(String number) {
        List<Character> numberList = new ArrayList<Character>();

        for (int index = 0; index < number.length(); index++) {
            numberList.add(number.charAt(index));
        }
        return numberList;
    }

    public static int getBallCount(String computerNumber, String userNumber) {
        List<Character> appeared = convertStringToArrayList(computerNumber);
        int ball = 0;

        for (int index = 0; index < computerNumber.length(); index++) {
            char userNum = userNumber.charAt(index);

            if ((computerNumber.charAt(index) != userNum) && (appeared.contains(userNum))) {
                // 위치는 다르지만 같은 숫자가 양쪽 모두 존재하는 경우 ball
                ball += 1;
            }
        }
        return ball;
    }

    public static int getStrikeCount(String computerNumber, String userNumber) {
        int strike = 0;

        for (int index = 0; index < computerNumber.length(); index++) {
            if (computerNumber.charAt(index) == userNumber.charAt(index)) {
                strike += 1;
            }
        }
        return strike;
    }

    public static String getBallStrikeCountMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        String message = "";
        if (ball != 0) {
            message = message + String.valueOf(ball) + "볼";
        }

        if (strike != 0) {
            if (message.length() == 0) {
                message = message + String.valueOf(strike) + "스트라이크";
            } else {
                message = message + " " + String.valueOf(strike) + "스트라이크";
            }
        }
        return message;
    }

    public static boolean checkEndGame(String ballStrikeCountMessage) {
        return ballStrikeCountMessage.equals("3스트라이크");
    }

    public static void startGame(String computerNumber) {
        while (true) {
            String userNumber = getUserNumber();
            checkIllegalArgumentException(userNumber);

            int ball = getBallCount(computerNumber, userNumber);
            int strike = getStrikeCount(computerNumber, userNumber);

            String resultMessage = getBallStrikeCountMessage(ball, strike);
            System.out.println(resultMessage);

            if (checkEndGame(resultMessage)) {
                break;
            }
        }
    }

    public static boolean checkRestartGame(String continueGame) {
        if (continueGame.equals("1")) {
            return true;
        } else if ((continueGame.equals("2"))) {
            return false;
        } else {
            throw new IllegalArgumentException("게임 진행 여부에 대한 수를 잘못 입력하셨습니다!");
        }
    }
}
