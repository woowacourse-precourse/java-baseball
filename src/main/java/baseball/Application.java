package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static boolean game;
    private static boolean isNot3Strike;

    private static List<Integer> computerNum;
    private static List<Integer> myNum;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");
        //숫자 야구게임 완전히 끝나는 반복문
        do {
            game = true;
            startGame();
        } while (game);
        System.out.println("게임 종료");
    }

    public static void startGame() {
        computerNum = computerNumber();
        isNot3Strike = true;
        //컴퓨터 숫자 맞춰야만 끝나는 반복문
        do {
            myNumber();
            StrikeOrBall();
        } while (isNot3Strike);
        //3스트라이크로 한게임 종료 후, 게임 더 할거야?
        moreGame();
    }

    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void myNumber() {
        System.out.println("숫자를 입력하세요");
        String inputNum = readLine();
        validNumber(inputNum);
        toInteger(inputNum);
    }

    public static void validNumber(String inputNum) {

        validLength(inputNum);
        validDuplication(inputNum);
        validNotNumber(inputNum);
    }

    public static void validLength(String inputNum) {
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validDuplication(String inputNum) {
        if (inputNum.charAt(0) == inputNum.charAt(1) || inputNum.charAt(1) == inputNum.charAt(2) || inputNum.charAt(0) == inputNum.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validNotNumber(String inputNum) {
        for (int i = 0; i < 3; i++) {
            if (inputNum.charAt(i) < '1' || inputNum.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void toInteger(String inputNum) {
        myNum = new ArrayList<>();
        myNum.add(inputNum.charAt(0) - '0');
        myNum.add(inputNum.charAt(1) - '0');
        myNum.add(inputNum.charAt(2) - '0');
    }

    public static void StrikeOrBall() {
        int strike = isStrike();
        int ball = isBall();
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isNot3Strike = false;
        } else if ((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
        } else if ((strike == 0) && (ball != 0)) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static void moreGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameNum = readLine();
        char overGame = gameNum.charAt(0);
        if (overGame == '1'){
            startGame();
        } else {
            game = false;
        }
    }

    public static Integer isStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i) == myNum.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    public static Integer isBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if ((computerNum.get(i) != myNum.get(i)) && (computerNum.contains(myNum.get(i)))) {
                ball +=1;
            }
        }
        return ball;
    }

}
