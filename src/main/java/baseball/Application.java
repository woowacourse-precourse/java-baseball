package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    final static int RESTART = 1;
    final static int GAME_OVER = 2;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while (true) {
            List<Integer> computerNumber = computerRanmdomNumberExtract();
            playGame(computerNumber);

            int userDecision = getUserDecision();
            if(isGameOver(userDecision, RESTART, GAME_OVER)){
                break;
            }
        }

    }
    public static List<Integer> computerRanmdomNumberExtract() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void playGame(List<Integer> computerNumber) {
        while (true) {
            System.out.print("숫자를 입력하세요 : ");
            String inputUserNumber = getInputUserNumber();
            List<Integer> userNumberList = inputProcess(inputUserNumber);
            int strike = 0;
            int ball = 0;
            List<Integer> strikeBall = findStrikeBall(computerNumber, userNumberList, strike, ball);
            strike = strikeBall.get(0);
            ball = strikeBall.get(1);
            printGameResult(strike, ball);
            if (strike == 3) {
                break;
            }

        }
    }

    public static List<Integer> findStrikeBall(List<Integer> computerNumber,
        List<Integer> userNumberList,
        int strike, int ball) {
        for (int i = 0; i < 3; i++) {
            if (isStrike(computerNumber.get(i), userNumberList.get(i))) {
                strike++;
            } else {
                ball = getBall(computerNumber, userNumberList, ball, i);
            }
        }
        return Arrays.asList(strike, ball);
    }



    public static boolean isStrike(int computer, int user
    ) {
        return computer == user;
    }

    public static int getBall(List<Integer> computerNumber, List<Integer> userNumberList, int ball,
        int i) {
        for (int j = 0; j < 3; j++) {
            if (i == j) {
                continue;
            }
            if (isBall(userNumberList.get(i), computerNumber.get(j))) {
                ball++;
            }
        }
        return ball;
    }
    public static boolean isBall(int user, int computer
    ) {
        return user == computer;
    }

    public static void printGameResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }


    public static Integer getUserDecision() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer user_decision = Integer.parseInt(Console.readLine());
        System.out.println("user_decision = " + user_decision);

        return user_decision;
    }

    public static boolean isGameOver(int userDecision, int RESTART, int GAME_OVER){
        if (userDecision == GAME_OVER) {
            return true;
        } else if (userDecision == RESTART) {
            return false;
        } else {
            throw new IllegalArgumentException("사용자 결정 오류");
        }
    }

    public static String getInputUserNumber() {
        String inputUserNumber = Console.readLine();

        isInputAlright(inputUserNumber);
        return inputUserNumber;
    }

    public static void isInputAlright(String user1) {
        //입력시 길이가 숫자길이가 3이 아닌경우
        if (user1.length() != 3) {
            throw new IllegalArgumentException("입력 오류");
        }
        //중복된 숫자가 있는지?
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inputOverlapCheck(user1, i, j);
            }
        }
    }

    public static List<Integer> inputProcess(String userNumber) {
        return convertStringToIntegerList(userNumber);
    }

    public static List<Integer> convertStringToIntegerList(String userNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int putNumber = Character.getNumericValue(userNumber.charAt(i));
            userNumberList.add(putNumber);
        }
        return userNumberList;
    }

    public static void inputOverlapCheck(String user1, int i, int j) {
        if (i == j) {
            return;
        }
        if (user1.charAt(j) == user1.charAt(i)) {
            throw new IllegalArgumentException("입력 숫자중 중복");
        }
    }
}
