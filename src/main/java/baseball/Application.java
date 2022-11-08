package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int MAX_SIZE = 3;
    static int strikeCount = 0;
    static int ballCount = 0;

    private static List<Integer> makeRandomNum() {
        List<Integer> randomNum = new ArrayList<>();

        while (randomNum.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
        return randomNum;
    }

    private static List<Integer> makeInputList(String userInputNum) {
        List<Integer> userNum = new ArrayList<>();
        String[] userInputNumArray = userInputNum.split("");

        for (int i = 0; i < userInputNumArray.length; i++) {
            userNum.add(Integer.parseInt(userInputNumArray[i]));
        }
        return userNum;
    }

    private static void countBallStrike(List<Integer> randomNum, List<Integer> userNum) {

        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < randomNum.size(); i++) {
            if (randomNum.contains(userNum.get(i))) {
                ballCount += 1;
            }
        }

        for (int i = 0; i < randomNum.size(); i++) {
            if (randomNum.get(i).equals(userNum.get(i))) {
                strikeCount += 1;
                ballCount -= 1;
            }
        }
    }

    private static void printHint() {

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    private static boolean checkEnd(int strike) {

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

            String userChoice = Console.readLine();
            checkValidEndDecision(userChoice);

            if (userChoice.equals("1")) {
                return false;
            }

            if (userChoice.equals("2")) {
                return true;
            }
        }
        return false;
    }

    private static void checkValidUserNum(String userNum) {
        if (userNum.length() != 3) {
            throw new IllegalArgumentException("문자의 길이가 3이 아닙니다.");
        }
        if (!userNum.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력하셔야 됩니다.");
        }
    }

    private static void checkValidEndDecision(String choice) {
        if (choice.equals("1") || choice.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("선택한 선택지가 1이나 2가 아닙니다.");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> randomNum = new ArrayList<>();
        List<Integer> userNum = new ArrayList<>();


        randomNum = makeRandomNum();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            System.out.print("숫자를 입력해주세요 : ");
            String userInputNum = Console.readLine();
            checkValidUserNum(userInputNum);
            userNum = makeInputList(userInputNum);
            countBallStrike(randomNum, userNum);
            printHint();
            if (checkEnd(strikeCount)) {
                break;
            }
            if (strikeCount == 3) {
                randomNum = makeRandomNum();
            }
        }
    }
}