package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> createComputerLength3IntegerAnswerToList(){
        List<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }

        return computerAnswer;
    }

    public static void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printGetInputMessage(){
        System.out.println();
    }
    public static void InputNum() {
        String userNum = Console.readLine();
    }
}
