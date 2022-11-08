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
        if (inputNum.length() > 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validDuplication(String inputNum) {
    }
    public static void validNotNumber(String inputNum) {

    }
    public static void toInteger(String inputNum) {
    }
    public static void StrikeOrBall() {
        return ;
    }
    public static void moreGame() {
        return ;
    }
}
