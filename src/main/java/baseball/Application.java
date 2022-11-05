package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        int mode = 1;

        while (mode == 1) {
            List<Integer> computer = createComputerNumber();

            playBaseBallGame(computer);
            mode = inputMode();
        }
    }

    public static void playBaseBallGame(List<Integer> computer) {
        boolean endGame = false;

        while (!endGame) {
            System.out.println("숫자를 입력해주세요 : ");
            String userNumberString = Console.readLine();
            String[] userNumberStringList = userNumberString.split("");

            if (isWrongInput(userNumberStringList)) {
                throw new IllegalArgumentException("잘못된 입력값을 입력하셨습니다.");
            }

            List<Integer> user = toArrayList(userNumberStringList);

            endGame = isThreeStrike(computer, user);

            if (endGame) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else {
                List<Integer> strikeCount = checkStrikeCount(computer, user);
                printStrikeAndBall(strikeCount);
            }
        }
    }

    public static List<Integer> createComputerNumber() {
        List<Integer> userNumber = new ArrayList<>();

        while (userNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!userNumber.contains(randomNumber)) {
                userNumber.add(randomNumber);
            }
        }

        return userNumber;
    }

    public static List<Integer> toArrayList(String[] userNumberStringList) {
        List<Integer> userNumberIntegerList = new ArrayList<>();

        for (int i = 0; i < userNumberStringList.length; i++) {
            userNumberIntegerList.add(Integer.parseInt(userNumberStringList[i]));
        }

        return userNumberIntegerList;
    }

    public static boolean isWrongInput(String[] userNumberStringList) {
        if (isIntegerOrCharacter(userNumberStringList)
                || isInputLength(userNumberStringList)
                || isSameNumbers(userNumberStringList)
                || isContainZero(userNumberStringList)) {
            return true;
        }

        return false;
    }

    public static boolean isIntegerOrCharacter(String[] userNumberStringList) {
        for (int i = 0; i < userNumberStringList.length; i++) {
            if (!Character.isDigit(userNumberStringList[i].charAt(0))) {
                return true;
            }
        }

        return false;
    }

    public static boolean isInputLength(String[] userNumberStringList) {
        if (userNumberStringList.length > 3 || userNumberStringList.length < 1) {
            return true;
        }

        return false;
    }

    public static boolean isSameNumbers(String[] userNumberStringList) {
        List<String> haveNumberList = new ArrayList<>();

        for (int i = 0; i < userNumberStringList.length; i++) {
            if (haveNumberList.contains(userNumberStringList[i])) {
                return true;
            } else {
                haveNumberList.add(userNumberStringList[i]);
            }
        }

        return false;
    }

    public static boolean isContainZero(String[] userNumberStringList) {
        for (int i = 0; i < userNumberStringList.length; i++) {
            if (userNumberStringList[i].equals("0")) {
                return true;
            }
        }

        return false;
    }

    public static boolean isThreeStrike(List<Integer> computer, List<Integer> user) {
        return computer.equals(user);
    }

    public static List<Integer> checkStrikeCount(List<Integer> computer, List<Integer> user) {
        List<Integer> countResult = new ArrayList<>();

        int strikeCount = countStrike(computer, user);
        int ballCount = countStirkeAndBall(computer, user) - countStrike(computer, user);

        countResult.add(strikeCount);
        countResult.add(ballCount);

        return countResult;
    }

    public static int countStrike(List<Integer> computer, List<Integer> user) {
        List<Integer> computerSubUser = new ArrayList<>();

        for (int i = 0; i < computer.size(); i++) {
            computerSubUser.add(computer.get(i) - user.get(i));
        }

        return Collections.frequency(computerSubUser, 0);
    }

    public static int countStirkeAndBall(List<Integer> computer, List<Integer> user) {
        int count = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i))) {
                count += 1;
            }
        }

        return count;
    }

    public static void printStrikeAndBall(List<Integer> strikeCount) {
        if (strikeCount.get(0) == 0 && strikeCount.get(1) == 0) {
            System.out.println("낫싱");
        } else if (strikeCount.get(0) == 0 && strikeCount.get(1) > 0) {
            System.out.println(String.format("%d볼", strikeCount.get(1)));
        } else if (strikeCount.get(0) > 0 && strikeCount.get(1) == 0) {
            System.out.println(String.format("%d스트라이크", strikeCount.get(0)));
        } else {
            System.out.println(String.format("%s볼 %s스트라이크", strikeCount.get(1), strikeCount.get(0)));
        }
    }

    public static int inputMode() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());

        while (!(input == 1 || input == 2)) {
            System.out.println("잘못된 입력입니다.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Integer.parseInt(Console.readLine());
        }

        if (input == 2) {
            System.out.println("게임 종료.");
        }

        return input;
    }
}
