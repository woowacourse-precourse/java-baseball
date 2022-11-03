package baseball;


import camp.nextstep.edu.missionutils.Randoms;

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

}

class Umpire {
    static List<Integer> playerNumberList = new ArrayList<>();

    static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        changeStringToList(readLine());
    }

    private static void changeStringToList(String playerNumberString) {
        Integer playerNumber = Integer.parseInt(playerNumberString);

        while (playerNumber > 0) {
            playerNumberList.add(0, playerNumber % 10);
            playerNumber /= 10;
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
            System.out.println(Umpire.playerNumberList);
        }

    }
}
