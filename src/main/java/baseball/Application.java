package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

class Computer {
    static List<Integer> numberList = new ArrayList<>();

    static void getThreeRandomNumber() {
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
    }
}

class Player {
    static int number;
    static String numberString;
    static List<Integer> numberList = new ArrayList<>();

    static void writeNumber() {
        numberString = readLine();
    }
}

// todo readLine()이 널일때
class Umpire {
    static int strike = 0;
    static int ball = 0;
    static HashSet<Integer> strikeSet = new HashSet<>();

    static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        Player.writeNumber();
        changeStringToList();
    }

    private static void changeStringToList() {

        checkInput();

        while (Player.number > 0) {
            Player.numberList.add(0, Player.number % 10);
            Player.number /= 10;
        }
    }

    private static void checkInput() {
        try {
            Player.number = Integer.parseInt(Player.numberString);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("wrong Input");
        }

        if (Player.numberList.size() != 3)
            throw new IllegalArgumentException("wrong size");

        if (Application.getAnswer){

        }
    }


    static void getScore() {
        checkStrike();
        checkBall();
    }

    static void checkStrike() {

        for (int i = 0; i < 3; i++) {
            if (Computer.numberList.get(i) == Player.numberList.get(i)) {
                strike++;
                strikeSet.add(i);
            }
        }
    }

    static void checkBall() {
        for (int i = 0; i < 3; i++) {
            if (strikeSet.contains(i))
                continue;
            addBall(i);
        }
    }

    static void addBall(int i) {
        for (int j = 0; j < 3; j++) {
            if (Computer.numberList.get(i) == Player.numberList.get(j)) {
                ball++;
                break;
            }
        }
    }

    static void printResult() {
        if (strike == 3) {
            Application.getAnswer = true;
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        if (ball > 0)
            System.out.print(ball + "볼 ");
        if (strike > 0)
            System.out.println(strike + "스트라이크");
        if (ball == 0 && strike == 0)
            System.out.println("낫싱");
    }


}

public class Application {
   static boolean getAnswer = false;
    public static void main(String[] args) {
        Umpire.gameStart();
        while (true) {
            Computer.getThreeRandomNumber();
            while (!getAnswer) {
                Umpire.getNumber();
                Umpire.getScore();
                Umpire.printResult();
//                Umpire.whenFinish();
            }
        }
    }
}
