package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

class Computer {
    static void getThreeRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
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

class Umpire {

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

}

public class Application {
    public static void main(String[] args) {
        boolean getAnswer = false;
        Umpire.gameStart();
        Computer.getThreeRandomNumber();
        while (!getAnswer) {
            Umpire.getNumber();
            System.out.println(Player.numberList);
            return;
        }

    }
}
