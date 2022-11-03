package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
    static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}

public class Application {
    public static void main(String[] args) {
        Umpire.gameStart();
        Computer.getThreeRandomNumber();


    }
}
