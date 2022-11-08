package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean gameStart() throws IllegalArgumentException {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();

        getNumberOfComputer(computer);

        String ballCount = "";
        while (isNeedReEnter(ballCount)) {
            try {
                user = getNumberOfUserForList(user);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
            ballCount = getBallCount(computer, user);
            UI.printBallCount(ballCount);
        }

        UI.printAnswerMsg();
        int restartOrExit = Integer.parseInt(Console.readLine());
        boolean restartOrNot = setRestartOrNot(restartOrExit);
        return restartOrNot;
    }

    private static void getNumberOfComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private static boolean isValidStringInputOfUser(String stringInputOfUser) throws IllegalArgumentException {
        int num = 0;
        try {
            num = Integer.parseInt(stringInputOfUser);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 문자입니다.");
        }

        if (num > 1000 || num < 100) {
            throw new IllegalArgumentException("세 자리의 수가 아닙니다.");
        }

        int hundreds = num / 100;
        int tens = (num % 100) / 10;
        int ones = num % 10;

        if (hundreds == tens || hundreds == ones || tens == ones) {
            throw new IllegalArgumentException("서로 다른 세 자리의 수가 아닙니다.");
        }

        return true;
    }

    private static List<Integer> stringToList(String numOfUserString) {
        List<Integer> user = new ArrayList<>();
        int numOfUserInteger = Integer.parseInt(numOfUserString);

        int hundreds = numOfUserInteger / 100;
        int tens = (numOfUserInteger % 100) / 10;
        int ones = numOfUserInteger % 10;

        user.add(hundreds);
        user.add(tens);
        user.add(ones);

        return user;
    }

    private static boolean isNeedReEnter(String ballCount) {
        if (!ballCount.equals("3스트라이크")) {
            return true;
        } else {
            return false;
        }
    }

    private static List<Integer> getNumberOfUserForList(List<Integer> user) throws IllegalArgumentException {
        user.clear();
        UI.printInputNumOfUserMsg();

        String numberOfUserString;
        try {
            numberOfUserString = getNumberOfUserString();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        try {
            user = getNumberOfUser(user, numberOfUserString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return user;
    }

    public static String getNumberOfUserString() {
        String numOfUserString = Console.readLine();
        return numOfUserString;
    }

    private static List<Integer> getNumberOfUser(List<Integer> user, String numberOfUserString) throws
            IllegalArgumentException {

        try {
            isValidStringInputOfUser(numberOfUserString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        user = stringToList(numberOfUserString);
        return user;
    }

    private static String getBallCount(List<Integer> computer, List<Integer> user) {

        int countOfStrike = howMuchStrike(computer, user);
        int countOfBall = howMuchBall(computer, user);

        String totalCount = "";
        if (countOfBall == 0 && countOfStrike != 0) {
            totalCount = countOfStrike + "스트라이크";
        } else if (countOfBall != 0 && countOfStrike == 0) {
            totalCount = countOfBall + "볼";
        } else if (countOfBall == 0 && countOfStrike == 0) {
            totalCount = "낫싱";
        } else if (countOfBall > 0 && countOfStrike > 0) {
            totalCount = countOfBall + "볼 " + countOfStrike + "스트라이크";
        } else {
            totalCount = "비정상";
        }

        return totalCount;
    }

    private static int howMuchStrike(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static int howMuchBall(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;

        if (computer.get(0) == user.get(1) || computer.get(0) == user.get(2)) {
            ballCount++;
        }
        if (computer.get(1) == user.get(0) || computer.get(1) == user.get(2)) {
            ballCount++;
        }
        if (computer.get(2) == user.get(0) || computer.get(2) == user.get(1)) {
            ballCount++;
        }

        return ballCount;
    }

    private static boolean setRestartOrNot(int restartOrExit) {
        if (restartOrExit == 1) {
            return true;
        } else if (restartOrExit == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("비정상적인 값입니다.");
        }
    }

    private static void preSettingToRestartGame(List<Integer> computer, List<Integer> user) {
        computer.clear();
        getNumberOfComputer(computer);
        user.clear();
    }

    private static void restartGame(List<Integer> user) {
        getNumberOfUserForList(user);
    }

    public static void main(String[] args) {
        boolean repeatState = true;

        UI.printGameStartMsg();
        while (repeatState) {
            repeatState = gameStart();
        }
    }
}