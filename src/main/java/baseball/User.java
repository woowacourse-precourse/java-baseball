package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class User {

    public static List<Integer> inputBalls() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();
        List<Integer> userBallsList = checkUserInput(userInput);

        return userBallsList;
    }


    public static List<Integer> checkUserInput(String userInput) {

        if (userInput == null) {
            throw new IllegalArgumentException();
        }

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        int userInputNum = 0;

        try {
            userInputNum = Integer.parseInt(userInput);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return makeUserBalls(userInputNum);
    }


    private static List<Integer> makeUserBalls(int userInputNum) {

        List<Integer> userBallsList = Arrays.asList(userInputNum / 100, userInputNum % 100 / 10, userInputNum % 10);
        Stream<Integer> userBallStream = userBallsList.stream();

        int count = (int) userBallStream.distinct().count();
        if (count != 3) {
            throw new IllegalArgumentException();
        }

        if (userBallsList.contains(0)) {
            throw new IllegalArgumentException();
        }

        return userBallsList;
    }


    public static boolean wantRegame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        return checkRegameInput(userInput);
    }


    static boolean checkRegameInput(String userInput) {

        if ("1".equals(userInput)) {
            return true;

        } else if ("2".equals(userInput)) {
            return false;

        } else {
            throw new IllegalArgumentException();
        }
    }
}
