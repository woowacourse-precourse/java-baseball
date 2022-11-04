package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Operator op = new Operator();
        op.playGame();
    }
}

class Computer {
    private List<Integer> number;

    public void setNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        number = numberList;
    }
}

class Player {
    private List<Integer> number;

    public void inputNumber() {
        List<Integer> numberList = new ArrayList<>();
        int num = Integer.valueOf(Console.readLine());
        while(num>0) {
            numberList.add(num % 10);
            num /= 10;
        }
        Collections.reverse(numberList);
        number = numberList;
    }
}
class Operator {
    Computer computer;
    Player player;
    private int ballCount;
    private int strikeCount;
    private boolean correctAnswer;
    public Operator() {
        computer = new Computer();
        player = new Player();
        ballCount = 0;
        strikeCount = 0;
        correctAnswer = false;
    }
    public void playGame() {
        computer.setNumber();
        while(!correctAnswer) {
            player.inputNumber();
            compareNumber();
            showResult();
        }
    }
    public int compareNumber() {


        if(strikeCount==3)
            correctAnswer = true;
    }
    public void showResult() {

    }

}