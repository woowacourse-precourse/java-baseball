package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> computer = new ArrayList<>();
    public static List<Integer> user = new ArrayList<>();
    public static boolean continueGame;

    public static void main(String[] args) {
        baseballGame();
    }

    static void baseballGame() {
        continueGame = true;
        gameStart();

        while (continueGame) {
            setComputer();
            playGame();
            continueGame = playNewGame();
        }
    }

    static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void setComputer() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("컴퓨터가 생성한 값 : " + computer);
    }

    static void playGame() {
        boolean allStrike = true;
        while (allStrike) {
            readUser();
            allStrike = !compareBall();
        }
    }

    static void readUser() {
        String strArray[];

        strArray = getUser();
        setUser(strArray);
    }

    static String[] getUser() {
        System.out.print("숫자를 입력해 주세요 : ");
        String readStr = Console.readLine();
        System.out.println(readStr);
        String str[] = readStr.split("");
        return str;
    }

    static void setUser(String str[]) throws IllegalArgumentException {
        if (str.length != 3) {
            System.out.println("Illegal Argument Exception");
            throw new IllegalArgumentException();
        }
        user.clear();
        for (int i = 0; i < 3; i++) {
            user.add(Integer.parseInt(str[i]));
        }
    }

    static boolean compareBall() {
        boolean nothing;
        int strike, ball;

        if (isAllStrike()) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (isNothing()) {
            System.out.println("낫싱");
            return false;
        } else {
            ball = getBall();
            strike = getStrike();
            printBallStrike(ball, strike);
            return false;
        }
    }

    static boolean playNewGame() {
    }


    static boolean isAllStrike() {
    }

    static boolean isNothing() {
    }

    static int getBall() {
    }

    static int getStrike() {
    }

    static void printBallStrike(int ball, int strike) {
    }

}