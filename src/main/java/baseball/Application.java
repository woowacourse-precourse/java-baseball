package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static void baseballGame() {

    }

    static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    static void startGame() {

    }

    /*
    스트라이크 체크하는 메소드
    1의 자리 0
    10의 자리 1
    100의 자리 2

    params
    List<Integer> computer
    int number
    int digit

    return
    boolean result
     */
    static boolean checkStrike(List<Integer> computer, int number, int digit) {
        if(computer.get(digit) == number){
            return true;
        }
        return false;
    }

    static boolean checkBall() {
        return false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(generateNumber());
    }
}
