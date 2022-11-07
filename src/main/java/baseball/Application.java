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

        if (Player.numberString.length() != 3)
            throw new IllegalArgumentException("wrong size");
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

    static void addBall(int i){
        for (int j = 0; j < 3; j++) {
            if (Computer.numberList.get(i) == Player.numberList.get(j)) {
                ball++;
                break;
            }
        }
    }


}

public class Application {
    public static void main(String[] args) {
        boolean getAnswer = false;
        Umpire.gameStart();
        Computer.getThreeRandomNumber();
        while (!getAnswer) {
            Umpire.getNumber();

            System.out.println(Computer.numberList);
            System.out.println(Player.numberList);

            Umpire.getScore();

            System.out.println(Umpire.ball + " " + Umpire.strike);

            return;
        }

    }
}
