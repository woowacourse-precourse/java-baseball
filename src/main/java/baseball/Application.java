package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        Operator op = new Operator();
//        op.playGame();

    }
}

class Computer {
    private int number;

    public void setNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        int num = numberList.indexOf(0) * 100 + numberList.indexOf(0) * 10 + numberList.indexOf(0);
        this.number = num;
    }
}

class Player {
    private int number;

    public void inputNumber() {
        int num = Integer.valueOf(Console.readLine());
        this.number = num;
    }
}
//class Operator {
//    Computer com;
//    public void playGame() {
//        com.setNumber();
//
//    }
//}